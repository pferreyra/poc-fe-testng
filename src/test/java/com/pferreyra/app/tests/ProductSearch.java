package com.pferreyra.app.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.collections.Pair;

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
		String appliedSearch = landing.enterProductToSearch(search).getFilterTitleText();
		assertEquals(appliedSearch, search);
	}
	
	@Test(dataProvider = "search", dataProviderClass = TestData.class)
	public void filter(String search) {
		SoftAssert sa = new SoftAssert();
		ResultList resultsPage = landing.enterProductToSearch(search);
		for (int i = 0; i < resultsPage.listedFilters(); i++) {
			Pair<String, String> filters = resultsPage.applyFilters(i);
			sa.assertEquals(filters.first(), filters.second());
			resultsPage.removeFilter();
		}
		sa.assertAll();
	}

}
