package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/C:/CucumberAssignment/SampleProject/src/main/java/features/Rediff.feature",
		glue ={"stepDefiition"}
		)

public class TestRunner1 {

}
