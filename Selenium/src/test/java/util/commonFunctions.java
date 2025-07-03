package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class commonFunctions {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

        public WebDriver init_driver(String browser) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().window().maximize();
        return getDriver();

    }

    /**
     * this is used to get the driver with ThreadLocal
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

//    public void Windowhanlder(WebDriver driver)
//    {
//        String originalWindow = driver.getWindowHandle();
//        // Opens a new tab and switches to new tab
//        driver.switchTo().newWindow(WindowType.TAB);
//        // Opens a new window and switches to new window
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.switchTo().window(originalWindow);
//    }
//
//    public void SwitchToiframe(WebDriver driver)
//    {
//        //Using the ID
//        driver.switchTo().frame("buttonframe");
//        //Or using the name instead
//        driver.switchTo().frame("myframe");
//        // Or using the index,  Switches to the second frame
//        driver.switchTo().frame(1);
//
//        //Now we can click the button
//        driver.findElement(By.tagName("button")).click();
//        // Return to the top level
//        driver.switchTo().defaultContent();
//
//    }
//
//    public void alert(WebDriver driver)
//    {
//        //Click the link to activate the alert
//        driver.findElement(By.linkText("See a sample confirm")).click();
//        //Store the alert in a variable
//        Alert alert = driver.switchTo().alert();
//        //Store the alert in a variable for reuse
//        String text = alert.getText();
//        //Press the Cancel button
//        alert.dismiss();
//
//        //Press the OK button
//        alert.accept();
//    }
//
//        public void Orderedlist(WebDriver driver) {
//
//            try {
//                driver.get("https://example.com");
//                // Get element with tag name 'div'
//                WebElement element = driver.findElement(By.tagName("div"));
//                // Get all the elements available with tag name 'p'
//                List<WebElement> elements = element.findElements(By.tagName("p"));
//                for (WebElement e : elements) {
//                    System.out.println(e.getText());
//                }
//            } finally {
//                driver.quit();
//            }
//        }
//
//
//    public void selectDropdownOptionsList(WebDriver driver)
//    {
//        WebElement selectElement = driver.findElement(By.name("selectomatic"));
//        Select select = new Select(selectElement);
//        List<WebElement> optionList = select.getOptions();
//
//    }
    public static void explicitlywait(WebDriver driver, WebElement element, long waittimeinseconds)
    {
       new WebDriverWait(driver, Duration.ofSeconds(waittimeinseconds)).until(ExpectedConditions.visibilityOf(element));
    }

    public void ClickAndWait(WebDriver driver, WebElement element, long waittimeinseconds)
    {
       new WebDriverWait(driver, Duration.ofSeconds(waittimeinseconds)).until(ExpectedConditions.elementToBeClickable(element));

    }
//
//    public void isElementPresent(WebElement element, long waittimeinseconds)
//    {
//
//
//    }
//
//    public void selectByvisibleText(WebElement element, long waittimeinseconds)
//    {
//
//
//    }

}
