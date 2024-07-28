package DemoTestJourney.DemoTestJourney;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DemoTestJourney.utils.Constants;
import DemoTestJourney.utils.ServiceFactory;

/**
 * Hello world!
 *
 */
public class LoginPageClass extends ServiceFactory {

	@FindBy(xpath = "//*[@id='user-name']")
	WebElement userName;

	@FindBy(xpath = "//*[@id='password']")
	WebElement passWord;

	@FindBy(xpath = "//*[@id='login-button']")
	WebElement loginButton;

	@FindBy(xpath = "//*[@class='title']")
	WebElement productsElement;

	@FindBy(xpath = "//*[@id='login_credentials']")
	WebElement usernameList;

	@FindBy(xpath = "//*[@data-test='error']")
	WebElement errorLabel;

	public LoginPageClass() {

		PageFactory.initElements(driver, this);

	}

	public void launchOrangeHRM() {

		getWebDriver().get(Constants.SAUCE_DEMO_URL);
		
		takeScreenshot("SAUCE_DEMO_PAGE.png");

	}

	public void enterUsername(String username) {

		userName.sendKeys(username);

	}

	public void enterPassword(String password) {

		passWord.sendKeys(password);

	}

	public void clickLoginButton() {

		takeScreenshot("LOGIN_CREDS.png");
		loginButton.click();

	}

	public boolean validateLoginSuccess() {

		if (productsElement.getText().equalsIgnoreCase(Constants.PRODUCTS_TEXT)) {

			takeScreenshot("SUCCESS_LOGIN.png");
			return true;

		}

		return false;

	}

	public boolean checkUsernameValue() {

		String[] acceptedUsername = usernameList.getText().split("\n");

		for (int i = 1; i < acceptedUsername.length; i++) {
			if (acceptedUsername[i].equalsIgnoreCase(Constants.INCORRECT_USERNAME)) {
				return true;
			}

		}

		return false;

	}
	
	public boolean validateFailedLogin() {

		if (errorLabel.isDisplayed()) {

			takeScreenshot("LOGIN_FAILED.png");
			return true;

		}

		return false;

	}

}
