package TestScript;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Main;
import pageFactory.HomePage;

public class AboutUS extends Main {

	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void tc1_FactorialVerify() throws IOException, Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.About.click();
		Main.waitForVisibilityOfElement(homePage.aboutUsPage,driver);
		int linkSize = homePage.links.size();
		System.out.println(linkSize);
		Assert.assertEquals(homePage.links.size()>11, true,"not more then 11");
		System.out.println("End of the test..");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
