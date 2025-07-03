package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.ProductPage;
import util.commonFunctions;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ProductSelectionStep {

    private final ProductPage productpage = new ProductPage(commonFunctions.getDriver());
    Logger log = Logger.getLogger(LoginStepDef.class.getName());

    @When("I Select the first product pan")
    public void iSelectTheFirstProductPan() {
        productpage.selectproduct();
    }
//    @Then("Verify the product selected")
//    public void verifyTheProductSelected() {
//        String product_title = productpage.getproducttitle();
//        Assert.assertEquals(product_title, "Sauce Labs Bike Light");
//    }

    @And("Verify total Products")
    public void verifyTotalProducts() {
        //productpage.getProductlist();
    }

    @And("Add following products into cart and Verify the total items in cart")
    public void addFollowingProductsIntoCart(DataTable datatable) {
        List<List<String>> productList = datatable.asLists(String.class);
        for (List<String> result : productList)
        {
             productpage.getProductlist(result);
        }
        Assert.assertEquals(productpage.verifyTotalItemsinCart(), datatable.values().size());
    }

//    @Then("Verify the total items in cart")
//    public void verifyTheTotalItemsInCart() {
//        Assert.assertEquals(productpage.verifyTotalItemsinCart(), totalproducts);
//    }
}
