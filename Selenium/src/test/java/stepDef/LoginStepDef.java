package stepDef;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ProductPage;
import util.commonFunctions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.time.Duration;
import java.util.logging.Logger;


public class LoginStepDef {

    private LoginPage loginPage = new LoginPage(commonFunctions.getDriver());

    Logger log = Logger.getLogger(LoginStepDef.class.getName());

    @Given("^I am on swag app$")
    public void iAmOnSwagApp() {
        commonFunctions.getDriver().get("https://www.saucedemo.com");
    }

    @When("^I enter (.*) and (.*)$")
    public void iEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        log.info("logged");
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() {
        loginPage.clickLoginbutton();
    }

    @Then("^I am on the main Page$")
    public void iAmOnTheMainPage() {
        loginPage.Verifylogin();
    }

    @Then("^Verify the error massage (.*)$")
    public void verifyTheResult(String errormsg) {
        String actualtext = loginPage.Verifyinvalidlogin();
        Assert.assertEquals(errormsg, actualtext);
    }

    @And("I Select the product pan")
    public void iSelectTheProductPan() {
        loginPage.selectBurgerMenu();
    }

    @Then("I click on Logout button")
    public void iClickOnLogoutButton() {
        loginPage.ClickOnLogout();
    }

    @Then("Verify the Logout successfully")
    public void verifyTheLogoutSuccessfully() {
        Assert.assertTrue(loginPage.validatelogoutsuccess());
    }

}