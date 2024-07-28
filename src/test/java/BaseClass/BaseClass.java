package BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ExcelReader;
import DemoTestJourney.utils.ServiceFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;

public class BaseClass extends AbstractTestNGCucumberTests {
	
	
	@BeforeClass(alwaysRun = true)
	public void setUPClass() {
		System.out.println("this would setup environment before running the class");
	}
	
	@Test
    public void runCucumberTests() {
		
		ServiceFactory.testArray = ExcelReader.getSheetData(ServiceFactory.excelSheetName);
		
		for(String key : ServiceFactory.testArray.keySet()) {
			
			ServiceFactory.testData = ServiceFactory.testArray.get(key);
			
			if(ServiceFactory.testData.get(Constants.RUN_FLAG).toString().equalsIgnoreCase(Constants.YES)) {
				
				TestNGCucumberRunner cucumberRunner = new TestNGCucumberRunner(this.getClass());
				
			}
			
			
		}
		
    }
	
	@AfterMethod
	public void tearDown()
	{
		
		if (ServiceFactory.driver != null) {
			ServiceFactory.driver.quit();
        }
	}

}
