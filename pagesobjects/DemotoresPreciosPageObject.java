package com.Arbusta.pagesobjects;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.chrome.ChromeDriver;

@DefaultUrl("https://tools.demotores.com/frontend/tools/main")

public class DemotoresPreciosPageObject extends PageObject {
	
	
	//Usuario
	@FindBy(xpath="//INPUT[@id='userName']")
	public WebElementFacade txtUsuario;
	
	//Contraseña
	@FindBy(xpath="//INPUT[@id='password']")
	public WebElementFacade txtContrasena;
	
	//Botón Ingresar
	@FindBy(xpath="//BUTTON[@id='login-btn']")
	public WebElementFacade btnIngresar;


	//Botón Buscador
	@FindBy(xpath="//A[@href='https://tools.demotores.com/frontend/tools/newCar/newCarSearch.html?backendUserId=356'][text()='Buscador Vehiculos 0km']")
	public WebElementFacade lnkCarSearch;
	
	//Desplegable País
	@FindBy(css="INPUT[id='countries'] [name='countryId']")
	public WebElementFacade txtDrpCountry;
	
	//Desplegable Marca
	@FindBy(xpath="//SELECT[@id='brands']")
	public WebElementFacade txtDrpBrands;
	
	//Desplegable Modelo
	@FindBy(xpath="//SELECT[@id='models']")
	public WebElementFacade txtDrpModels;
	
	//Desplegable Versión
	@FindBy(xpath="//SELECT[@id='versions']")
	public WebElementFacade txtDrpVersions;
	
	//Desplegable Estado
	@FindBy(xpath="//SELECT[@id='stateTypeSearch']")
	public WebElementFacade dspEstado;
	
	//Botón Buscar
	@FindBy(xpath="//INPUT[@type='button']")
	public WebElementFacade btnBuscar;
	
	/* CHEVROLET */
	
	//Botón Autos
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade btnAutos;
	
	//Sección Publicaciones
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade btnPublicaciones;
		
	//Resultados de Búsqueda
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade txtResultados;
	
	//Flitro Fecha
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade btnFecha;
	
	//Año de búsqueda
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade txtAño;
	
	//Mes de búsqueda
	@FindBy(css="XXXXXXXXXXXX")
	public WebElementFacade txtMes;
	
	
	
	public void Login(String strtxtUsuario, String strtxtContrasena, String strtxtBusqueda)
	{
		txtUsuario.click();
		txtUsuario.sendKeys(strtxtUsuario);
		txtContrasena.click();
		txtContrasena.sendKeys(strtxtContrasena);
		btnIngresar.waitUntilClickable();
		btnIngresar.click();
		lnkCarSearch.waitUntilVisible();
		lnkCarSearch.click();
		txtDrpCountry.waitUntilClickable();
		txtDrpCountry.click();
		txtDrpCountry.selectByVisibleText("Argentina");
		txtDrpBrands.selectByVisibleText("Chevrolet");
		txtDrpModels.selectByVisibleText("Cobalt");
	//	txtDrpVersions.selectByVisibleText("Cobalt");
		//Select X = new Select(driver.findElement(By.id("countries")));
		//X.selectByVisibleText("Argentina");
		
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.chevrolet.com.ar/");
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.close();
	    Serenity.takeScreenshot();
	
	}
	
	
	
}