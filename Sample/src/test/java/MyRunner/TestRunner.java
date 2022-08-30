package MyRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features",
        glue = "stepDefinations",
        //tags = {"@Smoke"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:target/cucumber-reports"
        })
@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
