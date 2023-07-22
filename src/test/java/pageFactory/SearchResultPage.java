package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy (xpath="//span[text()='No results for ']")
	WebElement noResultErrorMsg;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean valdiateNoResultErrorMsgDisplay() {
		return noResultErrorMsg.isDisplayed();
	}
	
	public String returnActualSearchResultPageTitle() {
		return driver.getTitle();
	}
	
	public String returnExpectedSearchResultPageTitle(String product) {
		return "Amazon.com : "+product;
	}
	

}
