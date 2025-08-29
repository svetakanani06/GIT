package TestScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Main;
import pageFactory.HomePage;

public class UIValidationOfApplication extends Main {

	WebDriver driver;
	
	@BeforeTest
	public void preCondition() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
		Main.waitForSpectificTitle("Factoriall", driver);
	}
	
	@Test
	public void Tc1_HomePage() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Main.waitForVisibilityOfElement(homePage.IntegerTextBox, driver);
		Boolean display = homePage.IntegerTextBox.isDisplayed();
		Boolean Enable = homePage.IntegerTextBox.isEnabled();
		Assert.assertEquals(display, Enable,"Integer Textbox not Working not displayed and Enabled.");
		display = homePage.calculateBtn.isDisplayed();
		Enable = homePage.calculateBtn.isEnabled();
		Assert.assertEquals(display, Enable,"calculate not Working not displayed & not Enabled.");	
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
