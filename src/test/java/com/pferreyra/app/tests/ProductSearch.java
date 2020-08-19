package com.pferreyra.app.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pferreyra.app.pages.ResultList;

import helpers.BaseTest;
import helpers.TestData;
import listeners.GeneralListener;

import static org.testng.Assert.assertEquals;


import org.testng.annotations.Listeners;

@Listeners(GeneralListener.class)
public class ProductSearch extends BaseTest {



	@Test(dataProvider="search", dataProviderClass=TestData.class)
	public void search(String search) {
		String appliedSearch = landing.enterProductToSearch(search);
		assertEquals(appliedSearch, search);
	}
	
	@Test(dataProvider="search", dataProviderClass=TestData.class)
	public void filter(String search) {
		SoftAssert sa = new SoftAssert();
		ResultList resultsPage = landing.searchAndResults(search);
		int filtersNumber = resultsPage.listedFilters();
		for (int i = 0; i < filtersNumber; i++) {
			String appliedFilter = resultsPage.selectFilter(i);
			String appliedFilterTitle;
			if (appliedFilter == null) {
				appliedFilterTitle = null;
			} else {
				appliedFilterTitle = resultsPage.appliedFilterTitle();
			}
			sa.assertEquals(appliedFilterTitle, appliedFilter);
		}
		sa.assertAll();
//Pair P = Pair.of(2, 2);
//sa.assertEquals(P.first(),P.second());
	}

}
