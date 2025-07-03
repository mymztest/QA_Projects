package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.commonFunctions;
import util.configReader;

import java.time.Duration;
import java.util.Properties;

public class hooks {
    private commonFunctions cm;
    private WebDriver driver;
    private configReader configreader;
    Properties prop;

    @Before(order = 0)
    public void getProperty()
    {
        configreader = new configReader();
        prop = configreader.init_prop();
    }

        @Before(order = 1)
        public void launchBrowser() {
            String browserName = prop.getProperty("browser");
            cm = new commonFunctions();
            driver = cm.init_driver(browserName);
        }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After (order = 1)
    public void tearDown(Scenario scenario) {
        //if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        //}
    }
}

