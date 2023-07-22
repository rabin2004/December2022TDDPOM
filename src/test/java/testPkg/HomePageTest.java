package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pageFactory.HomePage;

public class HomePageTest extends BaseClass{
	HomePage hp;
	
	@BeforeMethod
	  public void loadApp() {
		initialization();
		hp = new HomePage();
	  }

	  @AfterMethod
	  public void closeApp() {
		  tearDown();
	  }
	
	@Test (dataProviderClass=dataPkg.HomePageMenuData.class, dataProvider="homePageMenuLinks")
  	public void homepageMenuLinkTest(String link) {
		hp.clickHomePageMenuLink(link);
		Assert.assertTrue(hp.validateMenuLinkPageURL(link));
	}
}
