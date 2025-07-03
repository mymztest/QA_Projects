package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankLogin {

    private WebDriver driver;
    By loginbtn = By.xpath("//button[@class='btn btn-primary btn-lg' and contains(text(),'Customer Login')]");

    public BankLogin(WebDriver driver)
    {
        this.driver = driver;

    }
    public void getloginbtn()
    {
        driver.findElement(loginbtn).click();
        //driver.findElement(loginbtn).sendKeys("p");
    }

}
