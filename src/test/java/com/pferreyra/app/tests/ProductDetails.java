package com.pferreyra.app.tests;

import org.testng.annotations.Test;

import com.pferreyra.app.pages.ProductView;
import com.pferreyra.app.pages.ResultList;

import helpers.BaseTest;
import helpers.TestData;
import listeners.GeneralListener;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Listeners;

@Listeners(GeneralListener.class)
public class ProductDetails extends BaseTest{
	ResultList resultsPage;
	ProductView productPage;



	@Test(dataProvider = "search", dataProviderClass = TestData.class)
	public void productDescription(String search) {
		landing.enterProductToSearch(search);
		resultsPage = new ResultList(driver);
		String selectedItemTitle = resultsPage.selectFirstItem();
		if (selectedItemTitle == null) {
			System.out.println("No listed products");
		} else {
			productPage = new ProductView(driver);
			String obtainedTitle = productPage.productPreview();
			assertEquals(obtainedTitle, selectedItemTitle);
		}
	}
}
