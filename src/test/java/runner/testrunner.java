package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/features/Peperfry_Scenarios.feature"
,glue= {"stepDefination"},format = {"pretty", "html:target/Destination"},tags={"@Test1"}
)

public class testrunner {

}
