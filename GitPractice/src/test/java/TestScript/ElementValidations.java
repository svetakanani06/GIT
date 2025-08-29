package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.HomePage;

public class ElementValidations {
	WebDriver driver;

	@BeforeTest
	public void preCondition() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
		Thread.sleep(3000);
	}

	@Test
	public void Tc1_ElementValidate() throws Exception {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Thread.sleep(3000);
		String placeholder = homePage.IntegerTextBox.getAttribute("placeholder");
		Assert.assertEquals(placeholder.equals("Enter an integer"), true, "not match");
		Assert.assertEquals(driver.getTitle(), "Factoriall", "Title not matched");
		Assert.assertEquals(driver.getCurrentUrl().contains("https"), true, "URL not contains https");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
