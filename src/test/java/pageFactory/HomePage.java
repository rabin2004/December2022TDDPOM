package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class HomePage extends BaseClass{
	// Creating pageFactory:
	//1. Create elements -> @FindBy annotations
	@FindBy (id="twotabsearchtextbox") // WebElement searchTxtBox = driver.findElement(By.id("twotabsearchtextbox"));
	WebElement searchTxtBox;
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	//2. initialize elements with driver through constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//3. Action/interaction with the element defined in a separate method
	public void enterProductInSearchTxtBox(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void clickHomePageMenuLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	public boolean validateMenuLinkPageURL(String link) {
		return driver.getCurrentUrl().contains(link.toLowerCase());
	}

}
