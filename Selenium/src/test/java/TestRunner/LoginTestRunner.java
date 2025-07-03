package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDef", "Hooks"},
        plugin = {"pretty", "rerun:target/reruntests.txt"},
        monochrome = true,
        tags = "@test1 or @test2 or @test3"
)

public class LoginTestRunner {
}
