package smokeTests.pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashSet;

public class OfferList {
	private final WebDriver driver;
	private final WebElement categoryDropDown;
	private final WebHeader webHeader;
	private WebElement inStoreTab;

	public OfferList(WebDriver driver) {
		this.driver = driver;
//		WebDriverWait driverWait = new WebDriverWait(driver, 5, 100);
//		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inStoreBtn")));
		inStoreTab = driver.findElement(By.id("inStoreBtn"));
		categoryDropDown = driver.findElement(By.id("currentCategory"));

		webHeader = new WebHeader(driver);
	}

	public OfferList checkInStoreTabIsSelected() {
		HashSet<String> inStoreClassAttribute = new HashSet<String>(Arrays.asList(inStoreTab.getAttribute("class").split(" ")));
		Assert.assertTrue(inStoreClassAttribute.contains("activeMomentLinkSlider"));
		Assert.assertTrue(inStoreClassAttribute.contains("activeMomentLinkSliderHome"));
		return this;
	}

	public OfferDetails selectOffer(int offerPositionInList) {
		WebElement offer = driver.findElement(By.id(String.format("InStoremomentTitle_%s_0", offerPositionInList)));
		offer.click();
		return new OfferDetails(driver);
	}
}
