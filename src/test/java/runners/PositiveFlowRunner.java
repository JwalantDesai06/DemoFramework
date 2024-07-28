package runners;

import org.junit.runner.RunWith;

import BaseClass.BaseClass;
import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ServiceFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/PositiveJourney.feature", glue = "steps", tags = "@PositiveFlow", plugin = {
		"pretty", "html:target/cucumber-reports", "json:target/cucumber-report.json" }, monochrome = true)

public class PositiveFlowRunner extends BaseClass {

	public PositiveFlowRunner() {
		
		ServiceFactory.excelSheetName = Constants.POSITIVE_FLOW_SHEET_NAME;
		
	}

}
