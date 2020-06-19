package com.pferreyra.app.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pferreyra.app.pages.HomePage;
import com.pferreyra.app.pages.ResultList;

import helpers.BaseTest;
import helpers.TestData;

import static org.testng.Assert.assertEquals;

import java.util.Objects;

import org.testng.annotations.BeforeMethod;

public class ProductSearch extends BaseTest {
	HomePage landing;
	ResultList resultsPage;
	SoftAssert sa = new SoftAssert();

	@BeforeMethod
	public void beforeMethod() {
		landing = new HomePage(driver);
	}

	@Test(dataProvider="search", dataProviderClass=TestData.class)
	public void search(String search) {
		String appliedSearch = landing.EnterProductToSearch(search);
		assertEquals(appliedSearch, search);
	}
	
	@Test(dataProvider="search", dataProviderClass=TestData.class)
	public void filter(String search) {
		landing.EnterProductToSearch(search);
		resultsPage = new ResultList(driver);
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

	}

}
