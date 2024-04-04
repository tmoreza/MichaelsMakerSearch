package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.MakerHomePage;
import page.ProductsSearchPage;
import util.BasePage;

public class SearchStepDefinitions extends BasePage{
	MakerHomePage makerHomePage;
	ProductsSearchPage productsSearchPage;
	
	@Given("User is on the {string} MakerPlace Home Page")
	public void userIsOnTheMakerPlaceHomePage(String browser) {
		init(browser);
		makerHomePage = PageFactory.initElements(driver, MakerHomePage.class);
		driver.get("https://www.michaels.com/makerplace");
		Assert.assertEquals("Failed to land on HomePage!",driver.getTitle(), "Handmade Crafts, Online Art Classes & How-To Guides | MakerPlace by Michaels");

	}

	@When("User enters the {string} in the searchBar field")
	public void userEntersTheStringInTheSearchBarField(String searchTerm) {
		makerHomePage.insertSearchTerm(searchTerm);
	}

	@When("User clicks on search button")
	public void userClicksOnSearchButton() {
		makerHomePage.clickSearchButton();
	}

	@Then("User should land on Products Search Page and find {string}")
	public void userShouldLandOnProductsSearchPageAndFindProducts(String searchTerm) {
		productsSearchPage = PageFactory.initElements(driver, ProductsSearchPage.class);
		boolean validationResult = productsSearchPage.validateSearchResults(searchTerm);
		Assert.assertTrue("No matching Products were displayed!", validationResult);

	}
	
	 @AfterStep
	    public void failLog(Scenario scenario) {
	        try {
	            if (scenario.isFailed()) {
	            	String scenarioName = scenario.getName();
	            	takeScreenshot(driver, scenarioName);
	            }
	        } catch (Exception e) {
				// TODO: handle exception
			}
	    }
	 
	 @After
	    public void tearDown() {
	       
	            driver.quit();
	        
	    }
	
}
