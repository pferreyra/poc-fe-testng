package com.pferreyra.app.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pferreyra.app.helpers.BasePage;

public class ProductView extends BasePage {
	@FindBy(className = "item-title__primary")
	private WebElement productTitle;
	@FindBy(className = "ui-pdp-title")
	private WebElement productTitleB;
	@FindBy(id = "BidButtonTop")
	private WebElement comprarAhoraButton;
	
	public ProductView(WebDriver driver) {
		super(driver);
	}
	
	public String productPreview() {
		try {
			return productTitle.getText();
		} catch (NoSuchElementException ex) {
			return productTitleB.getText();
		}
	}
	
	public void goToCheckout() {
		comprarAhoraButton.click();
	}

}
