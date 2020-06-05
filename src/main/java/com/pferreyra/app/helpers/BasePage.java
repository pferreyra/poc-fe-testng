package com.pferreyra.app.helpers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class BasePage {

	private WebDriver driver;
	protected final String baseUrl = "https://www.mercadolibre.com.ar/";

	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void ingresarSitio() {
		driver.get(baseUrl);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void ingresarPagina(String subDominio) {
		driver.get(baseUrl + subDominio);
	}
}
