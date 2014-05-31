package br.com.efraimgentil.selenium;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class ManipulandoElementos {

	WebDriver driver;
	private static final String ROOT = "http://localhost:8080/exemplos-selenium/formulario-complexo.jsp";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveManipularComboboxDeEducationESelecionar2grauCompleto(){
		driver.get(ROOT);
		
		Select select = new Select( driver.findElement( By.cssSelector("[name='education']")) );
		select.selectByVisibleText("2° grau completo");
		WebElement selectedOption = select.getFirstSelectedOption();
		
		assertEquals( "2° grau completo", selectedOption.getText() );
	}
	
	@Test
	public void deveSelecionarAMelhorParteDoDiaTardeENoite(){
		driver.get(ROOT);
		
		Select select = new Select( driver.findElement(By.id("dia")));
		
		select.selectByVisibleText("Tarde");
		select.selectByVisibleText("Noite");
		
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		assertSame( 2 , allSelectedOptions.size() );
	}
	
	@Test
	public void deveSelecionarTodosOsCombosDeComida(){
		driver.get(ROOT);
		
		List<WebElement> findElements = driver.findElements( By.cssSelector("[name^='food']") );
		for (WebElement webElement : findElements) {
			webElement.click();
			assertTrue("Checkbox deve ficar selecionado" , webElement.isSelected() );
		}
	
	}
	
	@Test
	public void deveEscreverNoTextAreaOutraComidaOValorChurrasco(){
		driver.get(ROOT);
		
		WebElement txtArea = driver.findElement( By.id("txtarea") );
		txtArea.clear();
		txtArea.sendKeys("Churrasco");
		
		assertEquals("Churrasco" , txtArea.getAttribute("value") );
	}
	
}