package com.pferreyra.app.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultList {
	private WebDriver driver;
	  private List<WebElement> list;
	  @FindBy(className="qcat-truncate")
	  private By filter; // cambiado de WebElement a By para que tome la lista de filtros cuando lo busca
	  @FindBy(className="applied-fliter")
	  private WebElement appliedFilter;
	  private List<WebElement> items;
	  @FindBy(className="main-title")
	  private By item;
	  private int i;
	  
	  public ResultList(WebDriver driver) {
	    this.driver = driver;
	  }

	  public int listedFilters() {
	    list = driver.findElements(filter);
	    int listSize = list.size();
	    return listSize;
	  }
	  
	  public String selectFilter(int i) {
		  this.i = i;
		  this.list = driver.findElements(filter);
	  	if (list.get(i).isDisplayed()) {
	  	    String title = list.get(i).getAttribute("Title");
	  	    list.get(i).click();
	  	    return title;
	  	} else {
	  		return null;
	  	}

	  }
	  
	  public String appliedFilterTitle () {
		    String appliedTitle = appliedFilter.getText();
		    System.out.println(appliedTitle);
		    driver.navigate().back();
		    return (appliedTitle);
		  }
	  
	  public String seleccionarPrimerItem() {
		    items = driver.findElements(item);
		    int listSize = items.size();
		    String itemTitle = null;
		    if (listSize > 0) {
		    	itemTitle = items.get(0).getText();
		    	items.get(0).click();
		    }
			return itemTitle;
		  }

	}