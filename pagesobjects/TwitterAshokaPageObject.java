package com.Arbusta.pagesobjects;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://twitter.com/login")
public class TwitterAshokaPageObject extends PageObject {
	/*
	 ---------------->Login<-----------------
	 */
	//Usuario
	@FindBy(xpath="(//INPUT[@type='text'])[1]")
	public WebElementFacade txtUser;
	//Contraseña
	@FindBy(xpath="(//INPUT[@type='password'])[1]")
	public WebElementFacade txtPass;
	//Ingresar
	@FindBy(css="(//INPUT[@type='submit'])[1]")
	public WebElementFacade btnLogin;
	/*
	 ---------------->Búsqueda<-----------------
	 */
	//Campo Busqueda
	@FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/form/div[1]/div/div/div[2]/input")
	public WebElementFacade txtSearch;
	//Botón Busqueda Avanzada
	@FindBy(xpath = "//SPAN[@class='css-901oao css-16my406 r-1qd0xha r-ad9z0x r-bcqeeo r-qvutc0'][text()='Búsqueda avanzada']")
	public WebElementFacade btnAdvSearch;
	//Campo Palabras
	@FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[1]/div/label/div[2]/div/input")
	public WebElementFacade txtKeywords;
	//Desplegable Idioma
	@FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div[6]/div[2]/select")
	public WebElementFacade txtLanguage;
	//Fecha Desde Mes
	@FindBy(css = "[aria-label='Desde'] [aria-label='Mes']")
	public WebElementFacade txtSinceMonth;
	//Fecha Desde Día
	@FindBy(css = "[aria-label='Desde'] [aria-label='Día'][data-focusable='true']")
	public WebElementFacade txtSinceDay;
	//Fecha Desde Anio
	@FindBy(css = "[aria-label='Desde'] [aria-label='Año'][data-focusable='true']")
	public WebElementFacade txtSinceYear;
	//Fecha Hasta Mes
	@FindBy(css = "[aria-label='Hasta'] [aria-label='Mes'][data-focusable='true']")
	public WebElementFacade txtToMonth;
	//Fecha Hasta Día
	@FindBy(css = "[aria-label='Hasta'] [aria-label='Día'][data-focusable='true']")
	public WebElementFacade txtToDay;
	//Fecha Hasta Anio
	@FindBy(css = "[aria-label='Hasta'] [aria-label='Año'][data-focusable='true']")
	public WebElementFacade txtToYear;

	//Botón Busqueda
	@FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[3]/div/div/span/span")
	public WebElementFacade btnSearch;
	
	public void Login(String strtxtUser, String strtxtPass)
	{
		txtUser.waitUntilVisible();
		txtUser.sendKeys(strtxtUser);
		txtPass.sendKeys(strtxtPass);
		txtPass.submit();
		Serenity.takeScreenshot();
		waitFor(2);
	}
	public void scrollToElement(WebElementFacade element) {
		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		  jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void ejecutar(WebElementFacade element) {
		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		  jse.executeScript("arguments[0].click();", element);
	}
	public void Search(String strtxtSearch, String strtxtKeywords, String strtxtLanguage, String strtxtSinceMonth,
			String strtxtSinceDay, String strtxtSinceYear, String strtxtToMonth, String strtxtToDay,
			String strtxtToYear)
	{
		txtSearch.waitUntilVisible();
		txtSearch.click();
		txtSearch.sendKeys(strtxtSearch);
		txtSearch.submit();
		btnAdvSearch.click();
		txtKeywords.waitUntilVisible();
		txtKeywords.click();
		txtKeywords.sendKeys(strtxtKeywords);
		scrollToElement(txtLanguage);
		txtLanguage.sendKeys(strtxtLanguage);
		txtLanguage.submit();
		txtSinceMonth.click();
		scrollToElement(txtSinceMonth);
		txtSinceMonth.sendKeys(strtxtSinceMonth);
		txtSinceMonth.submit();
		txtSinceDay.sendKeys(strtxtSinceDay);
		txtSinceDay.submit();
		txtSinceYear.sendKeys(strtxtSinceYear);
		txtSinceYear.submit();
		txtToYear.sendKeys(strtxtToYear);
		txtToYear.submit();
		txtToDay.sendKeys(strtxtToDay);
		txtToDay.submit();
		txtToYear.sendKeys(strtxtToYear);
		txtToYear.submit();
		btnSearch.click();
		waitFor(2);
	}
}