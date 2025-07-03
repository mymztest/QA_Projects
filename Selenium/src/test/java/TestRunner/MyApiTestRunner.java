package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/RestAPI.feature",
        glue = "stepDef",
        plugin = {"pretty", "json:target/MyReport/report.json", "junit:target/MyReport/report.xml"},
        tags = "@DEMO003"
)
public class MyApiTestRunner {
}
