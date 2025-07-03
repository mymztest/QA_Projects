package RerunFailedTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "RerunFailedTests",
        plugin = {"pretty", "rerun:target/reruntests.txt"},
        monochrome = true,
        features = {"@target/reruntests.txt"}
)
public class RerunFailedTests {
}
