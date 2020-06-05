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
	  private WebElement item;
	  private int i;
	  
	  public ResultList(WebDriver driver) {
	    this.driver = driver;
	  }

	  public int listedFilters() {
	    list = driver.findElements(filter);
	    int listadoSize = list.size();
	    return listadoSize;
	  }
	  
	  public String selectFilter(int i) {
		  this.i = i;
		  this.list = driver.findElements(filter);
	  	if (list.get(i).isDisplayed()) {
	  	    String titulo = list.get(i).getAttribute("Title");
	  	    list.get(i).click();
	  	    return titulo;
	  	} else {
	  		return null;
	  	}

	  }
	  
	  public String tituloFiltroAplicado () {
		    String tituloAplicado = driver.findElement(filtroAplicado).getText();
		    System.out.println(tituloAplicado);
		    driver.navigate().back();
		    return (tituloAplicado);
		  }
	  
	  public String seleccionarPrimerItem() {
		    items = driver.findElements(item);
		    int listadoSize = items.size();
		    String itemTitulo = null;
		    if (listadoSize > 0) {
		    	itemTitulo = items.get(0).getText();
		    	items.get(0).click();
		    }
			return itemTitulo;
		  }

	}