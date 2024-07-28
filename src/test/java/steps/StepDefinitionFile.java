package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;

import DemoTestJourney.DemoTestJourney.LoginPageClass;
import DemoTestJourney.DemoTestJourney.ProductPagePO;
import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ServiceFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitionFile extends ServiceFactory{

	WebElement productElement = null;

	@Given("^User launch the SauceDemo Url$")
	public void launchURL() {

		new LoginPageClass().launchOrangeHRM();

	}

	@Then("^User Proved the Username$")
	public void provideUsername() {		

		new LoginPageClass().enterUsername(testData.get(Constants.USERNAME));

	}

	@Then("^User Proved the Password$")
	public void providePassword() {

		new LoginPageClass().enterPassword(testData.get(Constants.PASSWORD));

	}

	@Then("^User Clicks on login button$")
	public void clickLoginButton() {

		new LoginPageClass().clickLoginButton();

	}

	@Then("^User should log into the Products page$")
	public void validateLogin() {

		boolean loginSuccess = new LoginPageClass().validateLoginSuccess();
		assertTrue(loginSuccess);

	}

	@Then("^User should check products availability$")
	public void checkProductAvailability() {

		WebElement productAvailable = new ProductPagePO().validateProductAvailable();
		assertNotNull(productAvailable);

		productElement = productAvailable;

	}

	@Then("^User clicks on product$")
	public void clickProduct() {

		new ProductPagePO().clickOnTheProduct(productElement);

	}

	@Then("^User should add product to cart$")
	public void addProductToCart() {

		new ProductPagePO().addProduct();

	}

	@Then("^User should go to cart and check product added$")
	public void goToCartAndValidateProduct() {

		String productName = new ProductPagePO().goToCartAndValidate();

		assertEquals(true, productName.equalsIgnoreCase(testData.get(Constants.PRODUCT_NAME)));

	}

	@Then("^User should click on checkout$")
	public void clickOnCheckout() {

		new ProductPagePO().checkoutClicked();

	}

	@Then("^User should enter details for delivery and click on continue$")
	public void enterDetails() {

		boolean detailsEntered = new ProductPagePO().enterDetails();

		assertTrue(detailsEntered);

	}

	@Then("^User shoudl capture order details$")
	public void captureOrderDetails() {

		new ProductPagePO().captureDetails();

	}

	@Then("^Click on finish$")
	public void clickFinish() {

		new ProductPagePO().clickFinish();

	}

	@Then("^User should check order placed sucessfully$")
	public void validateOrderPlaced() {

		assertTrue(new ProductPagePO().validateSucessMessage());

	}

	@Then("^User should navigate back to home$")
	public void backHome() {

		new ProductPagePO().nevigateBackHome();

	}
	
	@Then("^User should log out of the application$")
	public void logOutApplication() {

		new ProductPagePO().logOut();

	}
	
	@Then("^User checks username in valid username list$")
	public void checkUsername() {

		boolean validUsername = new LoginPageClass().checkUsernameValue();
		
		assertFalse(validUsername);	

	}
	
	@Then("^User should should see error message$")
	public void checkLoginFailed() {

			assertTrue(new LoginPageClass().validateFailedLogin());

	}
}
