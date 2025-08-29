package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage {

	@FindBy (name="number")
	public WebElement IntegerTextBox;
	
	@FindBy (id = "getFactorial" )
	public WebElement calculateBtn;
	
	@FindBy(xpath ="//*[text()='About']")
	public WebElement About;
	
	@FindBy(xpath="//*[text()='Terms and Conditions']")
	public WebElement terms;
	
	@FindBy(xpath="//*[text()='Privacy']")
	public WebElement privacy;
	
	@FindBy(xpath="//*[text()='Qxf2 Services']")
	public WebElement QxServices;
	
	@FindBy(xpath="//p[@id='resultDiv']")
	public WebElement FactorialNo;
	
	@FindBy(xpath="//a")
	public List<WebElement> links;
	
	@FindBy(xpath="//h1[text()='About the QA interview application']")
	public WebElement aboutUsPage;
	
	
}
