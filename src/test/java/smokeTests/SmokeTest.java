package smokeTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smokeTests.pageObjects.AllOffersPage;
import smokeTests.pageObjects.LoginPage1;
import smokeTests.pageObjects.LoginPage2;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SmokeTest {

	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void startBrowserAndGoToMobileWeb() {

		URL firefoxProfileDir = this.getClass().getClassLoader().getResource("FirefoxProfiles/ShareLocation");
		File profileDir = new File(firefoxProfileDir.getPath());
		FirefoxProfile firefoxProfile = new FirefoxProfile(profileDir);
		firefoxProfile.setPreference("browser.private.browsing.autostart", true);
		firefoxProfile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_2 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8H7 Safari/6533.18.5");
		driver = new FirefoxDriver(firefoxProfile);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(640, 1136));
		driver.manage().deleteAllCookies();
		driver.get("http://localhost:8087/moments");
	}

	@AfterClass(enabled = true, alwaysRun = true)
	public void quitFirefo() {
		driver.quit();
	}

	@Test
	public void login() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		LoginPage2 loginPage2 = loginPage1.checkSubmitIsDisabled().enterMsisdn("447700000119").checkSubmitIsEnabled().clickSubmit();
		loginPage2.checkSubmitIsDisabled().enterCode("4470000000").checkSubmitIsEnabled().clickSubmit();
	}

	@Test(dependsOnMethods = "login")
	public void allOffers() {
		AllOffersPage allOffersPage = new AllOffersPage(driver);
		allOffersPage.checkInStoreTabIsSelected();
	}

}
