package com.Arbusta.pagesobjects;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.facebook.com/")

public class FacebookAshokaPageObject extends PageObject {
	

	
	//Usuario
	@FindBy(xpath="//INPUT[@id='email']")
	public WebElementFacade txtUsuario; 
	
	//Contraseña
	@FindBy(xpath="//INPUT[@id='pass']")
	public WebElementFacade txtContrasena;
	
	//Botón Ingresar
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[3]/label")
	public WebElementFacade btnIngresar;
	
	//Campo de Búsqueda
	@FindBy(xpath="(//INPUT[@type='text'])[2]")
	public WebElementFacade txtBusqueda;
	
	//Botón Buscar
	@FindBy(xpath="//I[@class='_585_']")
	public WebElementFacade btnBuscar;
	
	//Sección Publicaciones
	@FindBy(xpath="//DIV[@class='_4xjz'][text()='Publicaciones']")
	public WebElementFacade btnPublicaciones;
		
	//Resultados de Búsqueda
	@FindBy(xpath="//DIV[@class='clearfix pbm']")
	public WebElementFacade txtResultados;
	
	//Flitro Fecha
	@FindBy(xpath="(//I[@class='_1u6s img sp_WA-P5sQKHoJ sx_34ca78'])[4]")
	public WebElementFacade btnFecha;
	
	//Año de búsqueda
	@FindBy(xpath="//SPAN[@class='_55pe'][text()='2020']")
	public WebElementFacade txtAño;
	
	//Mes de búsqueda
	@FindBy(css="span#_55pe")
	public WebElementFacade txtMes;
	
	public void scrollToElement(WebElementFacade element) {
		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		  jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	public void Login(String strtxtUsuario, String strtxtContrasena, String strtxtBusqueda)
	{
		txtUsuario.waitUntilVisible();
		txtUsuario.click();
		txtUsuario.clear();
		txtUsuario.sendKeys(strtxtUsuario);
		txtContrasena.click();
		txtContrasena.clear();
		txtContrasena.sendKeys(strtxtContrasena);
		btnIngresar.waitUntilClickable();
		btnIngresar.click();
		txtBusqueda.typeAndEnter(strtxtBusqueda);
		btnPublicaciones.waitUntilClickable();
		btnPublicaciones.click();
		waitFor(2);
		btnFecha.click();
		waitFor(8);
		scrollToElement(txtMes);
		txtMes.sendKeys("2");
		waitFor(20);
		scrollToElement(txtBusqueda);
		Serenity.takeScreenshot();
		
		
	}
	
	
	
}

