package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommonPage extends BasePage {
	
 
	public CommonPage(WebDriver driver)
	{
		super(driver);
	}
		
	@FindBy(xpath="//input[@name='q']")
	private	WebElement inpGoogleSearch;
	
	@FindBy(xpath="//a[@href='https://www.selenium.dev/']")
	private	WebElement clickSeleniumLink;
		

	public void enterSearchField(String searchText)
	{
		inputElementField(inpGoogleSearch, searchText);
	}
	
	public void clickEnterKey()
	{
		clickKeyStroke(inpGoogleSearch);
	}
	
	public void clickOnLinkPage()
	{
		clickOnElement(clickSeleniumLink);
	}
	
}
