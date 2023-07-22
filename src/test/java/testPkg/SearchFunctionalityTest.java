package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.CommonFunctionalities;
import pageFactory.HomePage;
import pageFactory.SearchResultPage;

public class SearchFunctionalityTest extends BaseClass{
	HomePage hp;
	SearchResultPage srp;
	CommonFunctionalities cf;
	
	
	@BeforeMethod
	  public void loadApp() {
		initialization();
		hp = new HomePage();
		srp = new SearchResultPage();
		cf = new CommonFunctionalities();
	  }

	  @AfterMethod
	  public void closeApp() {
		  tearDown();
	  }
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="positiveSearchData")
  	public void positiveSearchFunctionalityDataDrivenTestHittingEnterKey(String product) {
		hp.enterProductInSearchTxtBox(product);
		cf.hittingEnterKey();
		Assert.assertEquals(srp.returnActualSearchResultPageTitle(), 
				srp.returnExpectedSearchResultPageTitle(product));
	}
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="positiveSearchData")
  	public void positiveSearchFunctionalityDataDrivenTestClickSearchBtn(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchButton();
		Assert.assertEquals(srp.returnActualSearchResultPageTitle(), 
				srp.returnExpectedSearchResultPageTitle(product));
	}
	
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="negativeSearchData")
  	public void negativeSearchFunctionalityDataDrivenTestHittingEnterKey(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		cf.hittingEnterKey();
		Assert.assertTrue(srp.valdiateNoResultErrorMsgDisplay());
	}
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="negativeSearchData")
  	public void negativeSearchFunctionalityDataDrivenTestClickingSearchBtn(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		hp.clickSearchButton();
		Assert.assertTrue(srp.valdiateNoResultErrorMsgDisplay());
	}
}
