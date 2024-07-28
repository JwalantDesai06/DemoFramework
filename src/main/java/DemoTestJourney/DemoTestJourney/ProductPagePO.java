package DemoTestJourney.DemoTestJourney;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ExcelReader;
import DemoTestJourney.utils.ServiceFactory;

public class ProductPagePO extends ServiceFactory {

	@FindBy(xpath = "//*[@class='inventory_list']")
	WebElement availableProductList;
	
	@FindBy(xpath = "//*[@id='add-to-cart']")
	WebElement addTocart;
	
	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement goToCartButton;
	
	@FindBy(xpath = "//*[@class='inventory_item_name']")
	WebElement addedProductName;
	
	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath = "//*[@id='first-name']")
	WebElement firstName;

	
	@FindBy(xpath = "//*[@id='last-name']")
	WebElement lastName;

	
	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement zipCode;

	
	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueButtion;

	
	@FindBy(xpath = "//*[@data-test='payment-info-value']")
	WebElement paymentInfoElement;

	
	@FindBy(xpath = "//*[@data-test='shipping-info-value']")
	WebElement shippingInfoElement;

	
	@FindBy(xpath = "//*[@data-test='total-label']")
	WebElement totalPriceElement;

	
	@FindBy(xpath = "//*[@id='finish']")
	WebElement finishButton;

	@FindBy(xpath = "//*[@class='complete-header']")
	WebElement validationMessage;
	
	@FindBy(xpath = "//*[@id='back-to-products']")
	WebElement backHomeButton;
	
	@FindBy(xpath = "//*[@id='react-burger-menu-btn']")
	WebElement menuButton;

	public ProductPagePO() {

		PageFactory.initElements(driver, this);
	}

	public WebElement validateProductAvailable() {

		List<WebElement> inventoryItems = availableProductList.findElements(By.xpath("//*[@class='inventory_item']"));

		for (WebElement item : inventoryItems) {
			
			WebElement productNameElement = item.findElement(By.className("inventory_item_name"));
			String productName = productNameElement.getText();
			
			if(productName.equalsIgnoreCase(testData.get(Constants.PRODUCT_NAME))) {

				takeScreenshot("PRODUCT_AVAILABLE.png");
				return productNameElement;
			}
			
		}
		return null;

	}
	
	public void clickOnTheProduct(WebElement element) {
		
		element.click();
		takeScreenshot("PRODUCT_PAGE.png");
		
	}
	
	public void addProduct()
	{
		addTocart.click();
	}
	
	public String goToCartAndValidate()
	{
		goToCartButton.click();
		
		String productName = addedProductName.getText();
		takeScreenshot("PRODUCT_ADDED.png");
		return productName;
		
	}
	
	public void checkoutClicked()
	{
		checkoutButton.click();
		
	}
	
	public boolean enterDetails()
	{
		
		int count = 0;
		
		if(!Constants.FIRST_NAME.equals("")) {
			firstName.sendKeys(testData.get(Constants.FIRST_NAME));
			count++;
		}
		if(!Constants.LAST_NAME.equals("")) {
			lastName.sendKeys(testData.get(Constants.LAST_NAME));
			count++;
		}
		if(!Constants.POSTAL_CODE.equals("")) {
			zipCode.sendKeys(testData.get(Constants.POSTAL_CODE));
			count++;
		}
		
		if(count == 3) {
			takeScreenshot("DELIVERY_DETAILS_ADDED.png");
			continueButtion.click();
			return true;
		}
		
		return false;
		
	}
	
	public void captureDetails()
	{
		
		
		Map<String, String> detailsMap = new HashMap<String, String>();
		
		String paymentInfo = paymentInfoElement.getText();
		
		String shippingInfo = shippingInfoElement.getText();
		
		String totalPrice = totalPriceElement.getText().split(":")[1];

		detailsMap.put(Constants.PAYMENT_INFORMATION, paymentInfo.trim());

		detailsMap.put(Constants.SHIPPING_INFORMATION, shippingInfo.trim());

		detailsMap.put(Constants.TOTAL_PRICE, totalPrice.trim());
		
		takeScreenshot("ORDER_SUMMARY.png");
		for(String key : detailsMap.keySet()) {
			System.out.println(key + ": " + detailsMap.get(key));
		}
		
		ExcelReader.updateSheetData(detailsMap, Constants.POSITIVE_FLOW_SHEET_NAME);
		
	}
	
	public void clickFinish()
	{
		
		finishButton.click();
		
	}
	
	public boolean validateSucessMessage()
	{
		String validationSucess = validationMessage.getText();
		
		if(validationSucess.equalsIgnoreCase(Constants.THANK_YOU_MESSAGE))
		{
			takeScreenshot("ORDER_SUCCESS.png");
			return true;
		}
		
		return false;
	}
	
	public void nevigateBackHome()
	{
		
		backHomeButton.click();
		
	}
	
	public void logOut()
	{
		
		menuButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='logout_sidebar_link']")));
		logoutButton.click();
		takeScreenshot("LOGOUT_SUCCESS.png");
		
	}
	

}
