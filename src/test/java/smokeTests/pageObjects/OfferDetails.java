package smokeTests.pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferDetails {
	private final WebDriver driver;
	private WebElement useNowBtn;

	public OfferDetails(WebDriver driver) {
		this.driver = driver;
		useNowBtn = driver.findElement(By.id("useNow"));
	}

	public OfferDetails useNow() {
		useNowBtn.click();
		WebDriverWait driverWait = new WebDriverWait(driver, 10, 100);
		WebElement offerCodeSection = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enjoyRateContainer")));
		Assert.assertTrue(offerCodeSection.isDisplayed());
		return this;
	}
}
