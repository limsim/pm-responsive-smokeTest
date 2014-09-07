package smokeTests.pageObjects;

import junit.framework.Assert;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by limsim on 06/09/2014.
 */
public class AllOffersPage {
	private final WebDriver driver;
	private WebElement inStoreTab;

	public AllOffersPage(WebDriver driver) {
		this.driver = driver;
	}

	public AllOffersPage checkInStoreTabIsSelected() {
		WebDriverWait driverWait = new WebDriverWait(driver, 5, 100);
		driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inStoreBtn")));
		inStoreTab = driver.findElement(By.id("inStoreBtn"));
		HashSet<String> inStoreClassAttribute = new HashSet<String>(Arrays.asList(inStoreTab.getAttribute("class").split(" ")));
		Assert.assertTrue(inStoreClassAttribute.contains("activeMomentLinkSlider"));
		Assert.assertTrue(inStoreClassAttribute.contains("activeMomentLinkSliderHome"));
		return this;
	}
}
