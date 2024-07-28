package DemoTestJourney.utils;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class ServiceFactory {
	
	public static WebDriver driver = null;
	
	public static String excelSheetName = "";
	
	public static Map<String, HashMap<String, String>> testArray = null;
	
	public static  HashMap<String, String> testData = null;
	
	public static WebDriver getWebDriver() {
		
		System.setProperty("webdriver.chrome.driver", Constants.DRIVERS_DIRECTORY + "chromedriver.exe");
		
		driver = new ChromeDriver();
		
		return driver;
		
	}
	
	public static void takeScreenshot(String screenShotName) {
		
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshot = screenshotDriver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        String filePath = Constants.SCREENSHOTS_DIRECTORY + screenShotName;
        File destinationFile = new File(filePath);
        try {
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Screenshot taken: " + screenShotName);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
	
	

}
