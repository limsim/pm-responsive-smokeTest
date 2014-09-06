package smokeTests.pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by limsim on 06/09/2014.
 */
public class LoginPage1 {
	private final WebDriver driver;
	private WebElement msisdnTextField;
	private WebElement submitButton;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		msisdnTextField = driver.findElement(By.id("registerMsisdn"));
	}

	public LoginPage1 enterMsisdn(String msisdn) {
		msisdnTextField.sendKeys(msisdn);
		return this;
	}

	public LoginPage1 checkSubmitIsDisabled() {
		submitButton = driver.findElement(By.id("initRegistrationButton"));
		Assert.assertFalse(submitButton.isEnabled());

		return this;
	}

	public LoginPage2 clickSubmit() {
		submitButton.click();
		return new LoginPage2(driver);
	}

	public LoginPage1 checkSubmitIsEnabled() {
		Assert.assertTrue(submitButton.isEnabled());
		return this;
	}
}
