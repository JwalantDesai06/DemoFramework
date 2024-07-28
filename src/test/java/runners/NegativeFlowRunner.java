package runners;

import org.junit.runner.RunWith;

import BaseClass.BaseClass;
import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ServiceFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/NegativeJourney.feature", glue = "steps", tags = "@NegativeFlow", plugin = {
		"pretty", "html:target/cucumber-reports" }, monochrome = true)

public class NegativeFlowRunner extends BaseClass {

	public NegativeFlowRunner() {
		
		ServiceFactory.excelSheetName = Constants.NEGATIVE_FLOW_SHEET_NAME;
		
	}

}
