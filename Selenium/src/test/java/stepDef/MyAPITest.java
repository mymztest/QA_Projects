package stepDef;

//import io.cucumber.java.en.When;
//import cucumber.api.DataTable;
//import cucumber.api.PendingException;
//import io.cucumber.java.en.Then;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import org.apache.tools.ant.taskdefs.optional.sos.SOS;
//import org.junit.Test;
//import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class MyAPITest {

//
//    @When("^I send get request to this url and validate the status (.*)$")
//    public void iSendGetRequestToThisUrlBaseurlAndValidateTheStatusStatuscode(int statuscode) {
//        RestAssured.given().body().post();
//       String BASE_URL = "https://reqres.in/api/users?page=2";
//        Response response = RestAssured.get(BASE_URL);
//        Assert.assertEquals(response.getStatusCode(),statuscode);
//    }
//
//    @Then("^I verify Api response parameter \"([^\"]*)\" is eqaul to (.*)$")
//    public void iValidateThisIsEqaulToIdvalue(String param, int idvalue) {
//        String BASE_URL = "https://reqres.in/api/users?page=2";
//        Response response = RestAssured.get(BASE_URL);
//        JsonPath jsonPathEvaluator=response.jsonPath();
//        int actualvalue = jsonPathEvaluator.getInt(param);
//        Assert.assertEquals(actualvalue,idvalue,"Passed");
//
//    }
//
//
//
//    @When("^I send API request using following parameters for URL \"([^\"]*)\"$")
//    public void iSendAPIRequestUsingFollowingParametersForURLUrl(String url, DataTable data) {
//
        Response response = (Response) RestAssured.given().get(url).body();
//        //response.body().toString()
//        //RestAssured.post()
//        List <Map<String, String>> requestdata = data.asMaps(String.class, String.class);
//        //List <List<String>> requestbody = data.asLists(String.class);
//        for(Map<String, String> e : requestdata)
//        {
//            e = requestdata;
//            response.getBody().jsonPath().getMap(url);
//            response = RestAssured.post(String.valueOf(e), url);
//            System.out.println("response: " + response.prettyPrint());
//        }
//        //Response response = RestAssured.post(url,requestbody);
//        //System.out.println("response: " + response.prettyPrint());
//    }
}
