package com.pferreyra.app.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public WebDriver driver;
	protected final String baseUrl = "https://www.mercadolibre.com.ar/";

	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
 	}

	public void loadSite() {
		driver.get(baseUrl);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
//	public void ingresarPagina(String subDominio) {
//		driver.get(baseUrl + subDominio);
//	}
	
	/**
	 * Check if the element exist in the current loaded page.
	 * 
	 * @param element The element to check
	 * @return True if this element exist in the view, false otherwise.
	 */
	public boolean existInView(WebElement element) {
		try {
			element.isEnabled();
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
		
	}	
	
}
