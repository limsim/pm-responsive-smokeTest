package smokeTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import smokeTests.pageObjects.LoginPage1;
import smokeTests.pageObjects.LoginPage2;

public class SmokeTest {

	private WebDriver driver;

	@BeforeClass
	public void startBrowserAndGoToMobileWeb() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8087/moments");
	}

	@AfterClass
	public void quitFirefo() {
		driver.quit();
	}

	@Test
	public void login() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		LoginPage2 loginPage2 = loginPage1.checkSubmitIsDisabled().enterMsisdn("447700000119").checkSubmitIsEnabled().clickSubmit();
		loginPage2.checkSubmitIsDisabled().enterCode("4470000000").checkSubmitIsEnabled().clickSubmit();
	}

}
