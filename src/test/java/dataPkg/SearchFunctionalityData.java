package dataPkg;

import org.testng.annotations.DataProvider;

public class SearchFunctionalityData {
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] data = {	"apple"
//							,
//							"samsung",
//							"pixel"
							};
		return data;
	}

	@DataProvider
	public String[] negativeSearchData() {
		String[] data = {	"*^(*^*(^*@^*@(*89898342230957329523890"
//							,
//							"*^(*^*(^*@^*@(*89898342230957329523891"
				};
		return data;
	}
}
