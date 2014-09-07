package smokeTests.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by limsim on 07/09/2014.
 */
public class WebHeader {

	private final WebElement hamburgerMenu;
	private final WebElement priorityLink;
	private final WebDriver driver;
	private final WebElement logoutButton;

	public WebHeader(WebDriver driver) {
		this.driver = driver;
		hamburgerMenu = driver.findElement(By.id("trigger-overlay"));
		priorityLink = driver.findElement(By.linkText("PRIORITY"));
		logoutButton = driver.findElement(By.id("logout"));
	}

	public WebHeader clickHamburgerMenu() {
		hamburgerMenu.click();
		return this;
	}

	public LoginPage1 logout() {
		clickHamburgerMenu().logoutButton.click();
		return new LoginPage1(driver);
	}
}
