package DemoTestJourney.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	public static String DIRECTORY = System.getProperty("user.dir");
	
	public static String FILE_SEPARATER = System.getProperty("file.separator");
	
	public static String RESOURCES_DIRECTORY = DIRECTORY + FILE_SEPARATER + "src" + FILE_SEPARATER + "test" + FILE_SEPARATER 
			+ "resources" + FILE_SEPARATER;
	
	public static String SCREENSHOTS_DIRECTORY = RESOURCES_DIRECTORY + "ScreenShots" + FILE_SEPARATER;
	
	public static String DRIVERS_DIRECTORY = RESOURCES_DIRECTORY + "drivers" + FILE_SEPARATER;
	
	public static String EXCELFILE_DIRECTORY = RESOURCES_DIRECTORY + "DataRepo" + FILE_SEPARATER;
	
	public static String TEST_DATA_REPO = EXCELFILE_DIRECTORY + "TestDataRepository.xlsx";
	
	public static String SAUCE_DEMO_URL = "https://www.saucedemo.com/";
	
	public static String USERNAME = "UserName";
	
	public static String TESTCONSTANT = "Test";
	
	public static String PASSWORD = "Password";
	
	public static String PRODUCTS_TEXT = "Products";
	
	public static String PRODUCT_NAME = "ProductName";
	
	public static String FIRST_NAME = "FirstName";
	
	public static String LAST_NAME = "LastName";
	
	public static String POSTAL_CODE = "PinCode";
	
	public static String PAYMENT_INFORMATION = "Payment Information";
	
	public static String SHIPPING_INFORMATION = "Shipping Information";
	
	public static String TOTAL_PRICE = "Total Price";
	
	public static String THANK_YOU_MESSAGE = "Thank you for your order!";
	
	public static String INCORRECT_USERNAME = "JwalantDesai";
	
	public static String POSITIVE_FLOW_SHEET_NAME = "POSITIVE_FLOW";
	
	public static String NEGATIVE_FLOW_SHEET_NAME = "NEGATIVE_FLOW";
	
	public static String RUN_FLAG = "RunFlag";
	
	public static String YES = "Yes";
	
	public static Map<String, HashMap<String, HashMap<String, String>>> excelFileData = null;

}
