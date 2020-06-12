package com.pferreyra.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.pferreyra.app.helpers.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	@FindBy(name="as_word")
	private WebElement searchFor;

	@FindBy(className="nav-search-btn")
	private WebElement searchButton;
	
	@FindBy(className="breadcrumb__title")
	private WebElement filterTitle;
	WebDriverWait wait = new WebDriverWait(driver,3);

	
	public HomePage(WebDriver driver) {
		super(driver);
		loadSite();
        PageFactory.initElements(driver, this);

	}
	

	/**
	 * Enter a product to search for
	 * 
	 * @param search text of product to be searched
	 */
	public String EnterProductToSearch(String search) {
		searchFor.sendKeys(search);
		searchButton.click();
		wait.until(ExpectedConditions.visibilityOf(filterTitle));
		String appliedSearch = filterTitle.getText();
		return (appliedSearch);
	}

}
