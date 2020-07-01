package helpers;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="search")
	public static Object[][] getData() {
		return new Object[][]{ 
			new Object[] { "Sabanas" }, 
//			new Object[] { "Cafetera" }, 
//			new Object[] { "Cable" }, 
//			new Object[] { "Monitor" },
			};
	}

}
