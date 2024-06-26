package page;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class ProductsSearchPage {

	WebDriver driver;
	
	public ProductsSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(how = How.XPATH, using = "//p[text()='for \"stained glass\"']") WebElement SEARCH_RESULTS_TITLE_ELEMENT;

	
	//methods
	public boolean validateSearchResults(String searchTerm) {
		boolean searchResults = false;
		boolean searchContents = false;
		
		if(SEARCH_RESULTS_TITLE_ELEMENT.isDisplayed()) {
			searchResults = true;
		}		
		List<WebElement> SEARCH_RESULTS_CONTENTS = driver.findElements(By.partialLinkText(searchTerm));
		if (SEARCH_RESULTS_CONTENTS.size() != 0)
		{
			System.out.println("Number of links containing search term on page: " + SEARCH_RESULTS_CONTENTS.size());
			searchContents = true;
		}
		if (searchResults && searchContents == true) {
			return true;
		} else return false;
	}
	
	
}
