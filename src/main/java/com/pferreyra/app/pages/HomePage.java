package com.pferreyra.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.pferreyra.app.helpers.BasePage;

public class HomePage extends BasePage {
	@FindBy(name="as_word")
	private WebElement buscar;

	@FindBy(className="nav-search-btn")
	private WebElement botonBuscar;
	
	@FindBy(className="breadcrumb__title")
	private WebElement tituloFiltro;
	
	protected WebDriver driver;	

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		ingresarSitio();
		String currentURL = driver.getCurrentUrl();
		if (!baseUrl.equals(currentURL)) {
			System.out.println("El sitio ingresado es incorrecto, el sitio es: " + currentURL);
		}
	}

	/**
	 * Ingresar una búsqueda de producto
	 * 
	 * @param busqueda texto del producto a buscar
	 */
	public String ingresarBusqueda(String busqueda) {
		buscar.sendKeys(busqueda);
		botonBuscar.click();
		String busquedaAplicada = tituloFiltro.getText();
		return (busquedaAplicada);
	}

}
