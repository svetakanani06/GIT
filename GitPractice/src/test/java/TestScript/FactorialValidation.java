package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Main;
import jxl.Sheet;
import jxl.Workbook;
import pageFactory.HomePage;

public class FactorialValidation extends Main {
	static WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
	}

	@Test
	public void tc1_FactorialVerify() throws IOException, Exception {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		FileInputStream file = new FileInputStream("E:\\OneDrive\\Desktop\\ExcelData\\FactorialData.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet s = wb.getSheet("Sheet1");
		int rows = s.getRows();

		for (int j = 1; j < rows; j++) {
			homePage.IntegerTextBox.sendKeys(s.getCell(0, j).getContents());
			homePage.calculateBtn.click();
			Thread.sleep(400);
			WebElement factElement = homePage.FactorialNo;
			String[] arr = factElement.getText().split(" ");
			Assert.assertEquals(arr[arr.length - 1], s.getCell(1, j).getContents(), "not match");
			homePage.IntegerTextBox.clear();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
