package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MakerHomePage {

	WebDriver driver;
	
	public MakerHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(how = How.XPATH, using = "//input[@aria-label='Search Input']") WebElement SEARCHBAR_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@aria-label='Search Button']") WebElement SEARCH_BUTTON_ELEMENT;

	
	//methods
	public void insertSearchTerm(String searchTerm) {
		SEARCHBAR_ELEMENT.sendKeys(searchTerm);
	}
	
	public void clickSearchButton() {
		SEARCH_BUTTON_ELEMENT.click();

	}
	
	
	
	
	
	
}
