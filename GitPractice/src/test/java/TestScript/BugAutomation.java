package TestScript;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import base.Main;
import pageFactory.HomePage;

public class BugAutomation extends Main{

	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
	}
	
	@Test
	public void tc_PageVerifyPage() throws Exception {
		Main.waitForSpectificTitle("Factoriall", driver);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.terms.click();
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(driver.getCurrentUrl(), "https://qainterview.pythonanywhere.com/terms", "Current URL & Expected URL not Matched.");

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
