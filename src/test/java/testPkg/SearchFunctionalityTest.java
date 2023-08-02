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
	
	
	@BeforeMethod(alwaysRun=true)
	  public void loadApp() {
		initialization();
		hp = new HomePage();
		srp = new SearchResultPage();
		cf = new CommonFunctionalities();
	  }

	  @AfterMethod(alwaysRun=true)
	  public void closeApp() {
		  tearDown();
	  }
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="positiveSearchData",
			groups="smoke_test")
  	public void positiveSearchFunctionalityDataDrivenTestHittingEnterKey(String product) {
		hp.enterProductInSearchTxtBox(product);
		cf.hittingEnterKey();
		Assert.assertEquals(srp.returnActualSearchResultPageTitle(), 
				srp.returnExpectedSearchResultPageTitle(product));
	}
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="positiveSearchData",
			groups={"smoke_test","regression_test"})
  	public void positiveSearchFunctionalityDataDrivenTestClickSearchBtn(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchButton();
		Assert.assertEquals(srp.returnActualSearchResultPageTitle(), 
				srp.returnExpectedSearchResultPageTitle(product));
	}
	
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="negativeSearchData",
			groups={"smoke_test","integration_test"})
  	public void negativeSearchFunctionalityDataDrivenTestHittingEnterKey(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		cf.hittingEnterKey();
		Assert.assertTrue(srp.valdiateNoResultErrorMsgDisplay());
	}
	
	@Test (dataProviderClass=dataPkg.SearchFunctionalityData.class, dataProvider="negativeSearchData",
			groups="E2E_test")
  	public void negativeSearchFunctionalityDataDrivenTestClickingSearchBtn(String invalidProduct) {
		hp.enterProductInSearchTxtBox(invalidProduct);
		hp.clickSearchButton();
		Assert.assertTrue(srp.valdiateNoResultErrorMsgDisplay());
	}
}
