package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
	   this.driver	= driver;
	   PageFactory.initElements(driver,this);
	}
	
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void clickOnElement(WebElement element)
    {
		waitForElement(element);
		element.click();
    }
	
	public void inputElementField(WebElement element, String value)
    {
		waitForElement(element);
		element.sendKeys(value);
    }
	
	public void clickKeyStroke(WebElement element)
    {
		waitForElement(element);
		element.sendKeys(Keys.ENTER);
    }	
	
	public void navigateToLink(String URL)
	{
		driver.navigate().to(URL);
	}
	
}
