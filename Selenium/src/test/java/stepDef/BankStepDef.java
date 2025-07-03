package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BankLogin;
import util.commonFunctions;

public class BankStepDef {

    private BankLogin bankpage = new BankLogin(commonFunctions.getDriver());


    @Given("I am on XYZ Bank app")
    public void getbankurl()
    {
        commonFunctions.getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
    }

    @When("I click on login button")
    public void getloginbtn()
    {
        bankpage.getloginbtn();
    }

//    @When("I enter (.*) and (.*)")
//    public void enterlogin(String username, String pwd)
//    {
//
//    }
}
