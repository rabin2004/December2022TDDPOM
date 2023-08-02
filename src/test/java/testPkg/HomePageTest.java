package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.HomePage;

public class HomePageTest extends BaseClass{
	HomePage hp;
	
	@BeforeMethod(alwaysRun=true)
	  public void loadApp() {
		initialization();
		hp = new HomePage();
	  }

	  @AfterMethod(alwaysRun=true)
	  public void closeApp() {
		  tearDown();
	  }
	
	@Test (dataProviderClass=dataPkg.HomePageMenuData.class, dataProvider="homePageMenuLinks",
			groups={"smoke_test","regression_test","E2E_test"})
  	public void homepageMenuLinkTest(String link) {
		hp.clickHomePageMenuLink(link);
		Assert.assertTrue(hp.validateMenuLinkPageURL(link));
	}
	
	// XML parameter:
		// 1. define parameter in xml file - <parameter name="link" value="music"/>
		// 2. Method using xml parameter -> single parameter - @Parameters("link") | multiple parameters - @Parameters({"name_1","name_2"})
		// 3. define method parameter
		// 4. Use method parameter reference in the code
	
	@Parameters("link")
	@Test (groups={"smoke_test","regression_test","E2E_test"})
  	public void homepageMenuLinkTestFromXMLparameter(String link) {
		hp.clickHomePageMenuLink(link);
		Assert.assertTrue(hp.validateMenuLinkPageURL(link));
	}
}
