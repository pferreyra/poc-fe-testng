package com.pferreyra.app.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pferreyra.app.helpers.BasePage;

public class ResultList extends BasePage {
	@FindAll({ @FindBy(className = "qcat-truncate") })
	private List<WebElement> list;
	@FindBy(className = "applied-fliter")
	private WebElement appliedFilter;
	@FindAll({ @FindBy(className = "main-title") })
	private List<WebElement> items;

	public ResultList(WebDriver driver) {
		super(driver);
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
			String title = list.get(i).getAttribute("Title");
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
		driver.navigate().back();
		return appliedTitle;
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

}