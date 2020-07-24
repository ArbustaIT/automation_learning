package com.mytest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Assert;

public class FerAppTest {
	
public static WindowsDriver<WebElement> driver = null;	
	
//	@BeforeClass
//	public static void setUp() throws Exception {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability("app", "C:\\Users\\Alexis Arbusta\\Desktop\\Aplicación de pruebas - Fernando barrionuevo.exe");
//		cap.setCapability("plataformName", "Windows");
//		cap.setCapability("deviceName", "WindowsPC");
//		
//		try {
//			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"),cap);
//		}catch(MalformedURLException e){
//			e.printStackTrace();
//		}
//	}
	
//	@AfterClass
//	public static void cleanUp() throws Exception {
//		driver.quit();
//	}
	
@Before
public void openApp() throws Exception {
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("app", "C:\\Users\\Alexis Arbusta\\Desktop\\Aplicación de pruebas - Fernando barrionuevo.exe");
	cap.setCapability("plataformName", "Windows");
	cap.setCapability("deviceName", "WindowsPC");
	
	try {
		driver = new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723"),cap);
	}catch(MalformedURLException e){
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
}
	
@After
public void closeApp() throws Exception {
	driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	driver.quit();	
}
	
	public void irASegundaPestaña() {
		WebElement segundaPestaña = driver.findElementByName("Interactuando con controles");
		segundaPestaña.click();
	}
	
	public void createTask(WebElement element, WebElement button,String name) {
		element.sendKeys(name);
		button.click();
		element.clear();
	}
	
	@Test
	public void writeInBoxes() {
		//WebElement ejemploReemplazarTexto = driver.findElementByName("Ejemplo reemplazar texto");
		WebElement campoTextoUno = driver.findElement(By.xpath("//*[@AutomationId='Text1']"));
		WebElement campoTextodos = driver.findElement(By.xpath("//*[@AutomationId='Text2']"));
		campoTextoUno.sendKeys("Escribiendo en Tarea uno");
		campoTextodos.sendKeys("Escribiendo en Tarea dos");
	}

	@Test
	public void cambiarTextoButtonFour() {
		irASegundaPestaña();
		WebElement buttonThree = driver.findElement(By.xpath("//*[@AutomationId='button3']"));
		WebElement buttonFour = driver.findElement(By.xpath("//*[@AutomationId='button4']"));
		WebElement boxForChange = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		boxForChange.sendKeys("button99");
		buttonThree.click();
		boxForChange.clear();
		Assert.assertEquals("button99", buttonFour.getText());		
	}
	
	@Test
	public void clickCheckButton() {
		irASegundaPestaña();
		WebElement checkOne = driver.findElement(By.xpath("//*[@AutomationId='checkBox1']"));
		WebElement checkTwo = driver.findElement(By.xpath("//*[@AutomationId='checkBox2']"));
		checkTwo.click();
//		Assert.assertEquals(0, checkOne.getAttribute("Toggle.ToggleState"));
//		Assert.assertEquals(1, checkTwo.getAttribute("Toggle.ToggleState"));
		Assert.assertTrue(checkOne.getAttribute("Toggle.ToggleState").equalsIgnoreCase("0"));
		Assert.assertTrue(checkTwo.getAttribute("Toggle.ToggleState").equalsIgnoreCase("1"));
	}
	
	@Test
	public void desplegarValores() {
		irASegundaPestaña();
		WebElement buttonDesplegable = driver.findElement(By.xpath("//*[@Name='Abrir']"));
		buttonDesplegable.click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		List<WebElement> elementos = driver.findElements(By.xpath("//*[@LocalizedControlType='elemento de lista']"));

		Predicate<WebElement> bySize = webelement -> webelement.getAttribute("Name").length() > 2;
		List<WebElement> result = elementos.stream().filter(bySize).collect(Collectors.toList());
//		for(int i = 0; i<result.size(); i++) {
//				System.out.println(result.get(i).getAttribute("Name"));
//		}	
		Assert.assertEquals(5, result.size());
	}
	
	@Test
	public void createTaskAndAdd() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement button5 = driver.findElement(By.xpath("//*[@AutomationId='button5']"));
		WebElement checkedListBox1 = driver.findElement(By.xpath("//*[@AutomationId='checkedListBox1']"));
		textBox1.sendKeys("primer tarea");	
		button5.click();
		WebElement taskCreated = checkedListBox1.findElement(By.xpath("//*[@Name='primer tarea']"));
		Assert.assertEquals("False", taskCreated.getText());
	}
	
	@Test
	public void checkTrueTaskCreated() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement button5 = driver.findElement(By.xpath("//*[@AutomationId='button5']"));
		WebElement checkedListBox1 = driver.findElement(By.xpath("//*[@AutomationId='checkedListBox1']"));
		textBox1.sendKeys("tarea true action");	
		button5.click();
		WebElement taskCreated = checkedListBox1.findElement(By.xpath("//*[@Name='tarea true action']"));
		taskCreated.click();
		taskCreated.click();		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertTrue("1", taskCreated.getAttribute("Toggle.ToggleState").equalsIgnoreCase("1"));
	}
	
	@Test
	public void validateCantidadTaskCreadas() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement button5 = driver.findElement(By.xpath("//*[@AutomationId='button5']"));
		WebElement checkedListBox1 = driver.findElement(By.xpath("//*[@AutomationId='checkedListBox1']"));
		createTask(textBox1,button5,"tarea 1");
		createTask(textBox1,button5,"tarea 2");
		createTask(textBox1,button5,"tarea 3");
		createTask(textBox1,button5,"tarea 4");
		List <WebElement> lista = checkedListBox1.findElements(By.xpath("//*[@LocalizedControlType='casilla']"));
		Assert.assertEquals(4, lista.size());
	}
	
	@Test
	public void deleteTask() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement buttonAddTask = driver.findElement(By.xpath("//*[@AutomationId='button5']"));
		WebElement buttonDelTask = driver.findElement(By.xpath("//*[@AutomationId='button6']"));
		WebElement checkedListBox1 = driver.findElement(By.xpath("//*[@AutomationId='checkedListBox1']"));
		createTask(textBox1,buttonAddTask,"tarea 1");
		createTask(textBox1,buttonAddTask,"tarea 2");
		createTask(textBox1,buttonAddTask,"tarea 3");
		createTask(textBox1,buttonAddTask,"tarea 4");
		List <WebElement> list = checkedListBox1.findElements(By.xpath("//*[@LocalizedControlType='casilla']"));
		int listSize = list.size();
		String taskToDelete = "tarea 3";		
		String xpathTask = "//*[@Name='"+ taskToDelete +"']";
		WebElement taskToDeleteWebElement = driver.findElement(By.xpath(xpathTask));
		taskToDeleteWebElement.click();
		buttonDelTask.click();
		List <WebElement> modifiedList = checkedListBox1.findElements(By.xpath("//*[@LocalizedControlType='casilla']"));
		int modifiedListSize = modifiedList.size();
		//Assert.assertTrue(modifiedListSize < listSize);
		Assert.assertEquals(listSize-1, modifiedListSize);
	}
	
	@Test
	public void selectRadioButton() {
		irASegundaPestaña();
		WebElement radioBtnOne = driver.findElement(By.xpath("//*[@AutomationId='radioButton1']"));
		WebElement radioBtnTwo = driver.findElement(By.xpath("//*[@AutomationId='radioButton2']"));
		radioBtnOne.click();
		Assert.assertEquals("True", radioBtnOne.getAttribute("SelectionItem.IsSelected"));
		Assert.assertEquals("False", radioBtnTwo.getAttribute("SelectionItem.IsSelected"));
	}
	
	@Test
	public void progressBar() {
		irASegundaPestaña();
		WebElement bar = driver.findElement(By.xpath("//*[@AutomationId='progressBar1']"));
		System.out.println("El valor de la barra de progreso es del: "+bar.getAttribute("Value.Value"));
	}
	
	@Test
	public void createTaskAndAddToTextList() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement buttonAddTaskToTextList = driver.findElement(By.xpath("//*[@AutomationId='button8']"));
		
		createTask(textBox1,buttonAddTaskToTextList,"Tarea 1");		
		createTask(textBox1,buttonAddTaskToTextList,"Tarea 2");
		
		WebElement listBoxText = driver.findElement(By.xpath("//*[@AutomationId='listBox1']"));	
		
		WebElement taskOneInList = listBoxText.findElement(By.xpath("//*[@Name='Tarea 1']"));		
		WebElement taskThreeInList = listBoxText.findElement(By.xpath("//*[@Name='Tarea 2']"));

		Assert.assertEquals("Tarea 1", taskOneInList.getAttribute("Name"));
		Assert.assertEquals("Tarea 2", taskThreeInList.getAttribute("Name"));
	}
	
	@Test
	public void deleteTaskToTextList() {
		irASegundaPestaña();
		WebElement textBox1 = driver.findElement(By.xpath("//*[@AutomationId='textBox1']"));
		WebElement buttonAddTaskToTextList = driver.findElement(By.xpath("//*[@AutomationId='button8']"));
		WebElement buttonDelTaskToTextList = driver.findElement(By.xpath("//*[@AutomationId='button7']"));
		
		createTask(textBox1,buttonAddTaskToTextList,"Tarea 1");
		createTask(textBox1,buttonAddTaskToTextList,"Tarea 2");
		
		WebElement listBoxText = driver.findElement(By.xpath("//*[@AutomationId='listBox1']"));	
		WebElement taskTextListOne = listBoxText.findElement(By.xpath("//*[@Name='Tarea 1']"));
		//WebElement taskTextListTwo = listBoxText.findElement(By.xpath("//*[@Name='Tarea 2']"));
		
		List<WebElement> listText = listBoxText.findElements(By.xpath("//*[@LocalizedControlType='elemento de lista']"));
		
		taskTextListOne.click();
		buttonDelTaskToTextList.click();
		
		Predicate<WebElement> ifExist = webelement -> webelement.getAttribute("Name") != null;
		List<WebElement> result = listText.stream().filter(ifExist).collect(Collectors.toList());
		
		Assert.assertEquals("Tarea 2", result.get(0).getAttribute("Name"));
		Assert.assertEquals(listText.size() - 1, result.size());
	}

}
