package base;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageFactory.HomePage;

public class Main {

	static WebDriver driver;
	static WebDriverWait wait;
	public static void waitForSpectificTitle(String title, WebDriver driver) {
		Main.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(title));
	}
	
	public static void waitForSpectificTime( WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static WebDriverWait WebDriverWait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}
	
	public static void waitForVisibilityOfElement(WebElement element, WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	public static void TextToBePresent(String text, WebElement element,  WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

}
