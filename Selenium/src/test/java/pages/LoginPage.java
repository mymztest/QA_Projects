package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import util.commonFunctions;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {


    private WebDriver driver;

    private By txt_username = By.xpath("//input[@id='user-name']");
    private By txt_password = By.id("password");
    private By login_button = By.id("login-button");
    private By title_txt = By.xpath("//div[@class='app_logo']");
    private By error_text = By.xpath("//h3[@data-test='error']");

    private By burger_menu = By.xpath("//button[@id='react-burger-menu-btn']");
    private By logout_button = By.id("logout_sidebar_link");


    /**
     * Initialise the driver
     * @param driver
     */
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void enterUsername(String username)
    {
        commonFunctions.explicitlywait(driver, driver.findElement(txt_username), 10);
        driver.findElement(txt_username).sendKeys(username);
    }
    public void enterPassword(String password)
    {
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLoginbutton()
    {
        driver.findElement(login_button).click();
    }

    public void Verifylogin()
    {
        String actualtxt = driver.findElement(title_txt).getText();
        Assert.assertEquals("Swag Labs", actualtxt);
    }

    public String Verifyinvalidlogin()
    {
        String errortext = driver.findElement(error_text).getText();
        return errortext;
    }

    public void selectBurgerMenu()
    {
        driver.findElement(burger_menu).click();
    }

    public void ClickOnLogout()
    {
        driver.findElement(logout_button).click();
    }

    public boolean validatelogoutsuccess()
    {
        return driver.findElement(login_button).isDisplayed();
    }
}
