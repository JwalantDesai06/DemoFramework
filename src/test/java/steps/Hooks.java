package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.aventstack.extentreports.ExtentTest;

public class Hooks {
    private ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {
        test = ExtentManager.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
        ExtentManager.flush();
    }
}
