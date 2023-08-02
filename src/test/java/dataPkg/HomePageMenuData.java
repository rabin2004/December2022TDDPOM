package dataPkg;

import org.testng.annotations.DataProvider;

public class HomePageMenuData {
	
	@DataProvider
	public String[] homePageMenuLinks() {
		String[] link = {	"Clinic"
//							,
//							"Music",
//							"Books"
							};
		return link;
	}

}
