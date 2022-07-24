package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonPage;

public class TestStep {

	WebDriver driver = null;
	public CommonPage commonPage; 

	@Before
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Given("I want to go to the {string} Page")
	public void i_want_to_go_to_the_Page(String webUrl) {
		System.out.println("I want to navigate to " + webUrl + "page");
	}

	@When("I go to {string}")
	public void i_go_to(String url) {
		commonPage = new CommonPage(driver);
		commonPage.navigateToLink(url);
	}

	@And("I type {string} in the searchbox")
	public void i_type_in_the_searchbox(String searchText) {
		commonPage.enterSearchField(searchText);
	}

	@And("I press ENTER in the searchbox")
	public void i_press_in_the_searchbox() {
		commonPage.clickEnterKey();
	}
	
	@And("I click on Selenium link")
	public void i_click_on_link() {
		commonPage.clickOnLinkPage();
	}

	@Then("I am on Selenium HQ Page")
	public void i_m_on_Selenium_HQ_Page() {		

		String title = driver.getTitle();
		Assert.assertEquals(title,"Selenium");
	}
	
	@After
	public void Cleanup(){
		driver.close();
		driver.quit();
	}
}
