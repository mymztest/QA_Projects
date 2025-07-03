package pages;

import com.google.gson.annotations.Until;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.commonFunctions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ProductPage {

    private WebDriver driver;
    private By productname = By.cssSelector("a#item_0_title_link");
    //private By producttitle = By.className("inventory_details_name large_size");
    private By productlist = By.cssSelector("div.inventory_item");
    private By gotocart = By.xpath("//a[@class='shopping_cart_link']");
    private By countitems = By.xpath("//div[@class='cart_quantity']");
    /**
     * Initialise the driver
     * @param driver
     */
    public ProductPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void selectproduct()
    {
        commonFunctions.explicitlywait(driver, driver.findElement(productname), 10);
        driver.findElement(productname).click();
    }

    public void getProductlist(List<String> e) {
        System.out.println(e.size());
        WebElement table1 = driver.findElement(By.xpath("//div[@class='inventory_list']"));
        List<WebElement> Itemsname = table1.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        for (int i = 0; i < e.size(); i++)
            for (WebElement items : Itemsname) {
                if (items.getText().equals(e.get(i))) {
                    System.out.println(items.getText());
                    WebElement ele = driver.findElement(By.xpath("//div[@class='inventory_item']//*[text()='" + items.getText() + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div//button"));
                    ele.click();
                }
            }
    }

//    public String getproducttitle()
//    {
//        return driver.findElement(producttitle).getText();
//    }

    public int verifyTotalItemsinCart() {
        driver.findElement(gotocart).click();
        List<WebElement> itemsoncart = driver.findElements(countitems);
        int totalItemsinCart = 0;
        for (WebElement items : itemsoncart) {
            totalItemsinCart = totalItemsinCart + 1;
        }
        return totalItemsinCart;
    }
}
