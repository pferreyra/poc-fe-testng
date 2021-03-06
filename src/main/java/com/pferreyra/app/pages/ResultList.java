package com.pferreyra.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.collections.Pair;

import com.pferreyra.app.helpers.BasePage;

public class ResultList extends BasePage {
	@FindAll({ @FindBy(xpath = "//span[@class='ui-search-filter-results-qty']/preceding-sibling::span[@class='ui-search-filter-name']")})
	private List<WebElement> list;
	@FindBy(className = "andes-tag__label")
	private WebElement appliedFilter;
	@FindAll({ @FindBy(className = "main-title") })
	private List<WebElement> items;
	@FindBy(css ="[class*=breadcrumb__title]")
	private WebElement filterTitle;
	@FindBy(id = "cookieDisclaimerButton")
	private WebElement cookieButton;
	@FindBy(css = ".andes-tag__close:enabled")
	private WebElement closeButton;

	public ResultList(WebDriver driver) {
		super(driver);
		removeCookiesBanner();
	}
	
	
	/**
	 * Accept cookies disclaimer
	 * 
	 * @param none
	 */
	public void removeCookiesBanner() {
		/*It have to be a try catch because this webelement only appears 
		 * the first time that ResultList it's displayed
		 * */
		try {
			wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();;
		} catch (Exception cookieEx) {
			System.out.println("No cookie disclaimer");
		}
	}
	
	/**
	 * Return the size of the list of filters for this page
	 * 
	 * @param none
	 */
	public int listedFilters() {
		int listSize = list.size();
		return listSize;
	}

	/**
	 * Get the title for a specific element of the list of filters
	 * 
	 * @param index of the element of the list
	 */
	public String selectFilter(int i) {
		if (list.get(i).isDisplayed()) {
			String title = list.get(i).getText();
			list.get(i).click();
			return title;
		} else {
			return null;
		}

	}
	
	/**
	 * Get the title of the applied once it's selected and page reloads
	 * Go back to the previous page once the title is obtained
	 * @param none
	 */
	
	public String appliedFilterTitle() {
		String appliedTitle = null;
		if (existInView(appliedFilter)) {
			appliedTitle = appliedFilter.getText();
		}
		return appliedTitle;
	}
	
	public void removeFilter() {
		wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
	}

	/**
	 * Select the first item from a list of items
	 * Returns the title of the item selected
	 * @param none
	 */
	public String selectFirstItem() {
		int listSize = items.size();
		String itemTitle = null;
		if (listSize > 0) {
			itemTitle = items.get(0).getText();
			items.get(0).click();
		}
		return itemTitle;
	}
	
	/**
	 * Getter of Filter's Title
	 * @param none
	 * @return Filter's Title text
	 */
	
	public String getFilterTitleText() {
		return filterTitle.getText();
	}
	
	/**
	 * Select a filter based in an index
	 * Get filter's title once it's applied
	 * @param index of the filter list
	 * @return filter applied and its title
	 */

	public Pair<String, String> applyFilters(int i) {
		String appliedFilter = selectFilter(i);
		String appliedFilterTitle = null;
		if (appliedFilter != null) {
			appliedFilterTitle = appliedFilterTitle();
		}
		return Pair.of(appliedFilterTitle,appliedFilter);
	}

}