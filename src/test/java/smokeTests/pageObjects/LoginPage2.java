package smokeTests.pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage2 {
	private final WebDriver driver;
	private final WebElement completeRegisterDiv;
	private WebElement submitButton;
	private WebElement registerPin;

	public LoginPage2(WebDriver driver) {
		this.driver = driver;
		completeRegisterDiv = driver.findElement(By.id("completeRegister"));
		submitButton = driver.findElement(By.id("completeRegistrationButton"));
		registerPin = driver.findElement(By.id("registerPin"));

		WebDriverWait driverWait = new WebDriverWait(driver, 5, 100);
//		driverWait.until(ExpectedConditions.visibilityOf(completeRegisterDiv));
	}

	public LoginPage2 checkSubmitIsDisabled() {
		Assert.assertFalse(submitButton.isEnabled());
		return this;
	}

	public LoginPage2 enterCode(String code) {
		registerPin.sendKeys(code);
		return this;
	}

	public LoginPage2 checkSubmitIsEnabled() {
		Assert.assertTrue(submitButton.isEnabled());
		return this;
	}

	public AllOffersPage clickSubmit() {
		submitButton.click();
		return new AllOffersPage(driver);
	}
}
