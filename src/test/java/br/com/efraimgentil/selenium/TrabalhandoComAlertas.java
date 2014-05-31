package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class TrabalhandoComAlertas {
	
	WebDriver driver;
	final String PAGINA_FORMULARIO = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/alert_confirmation/inc.auth.php";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveClicarOkNoAlert(){
		driver.get(PAGINA_FORMULARIO);
		
		driver.findElement(By.id("submit")).click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Preencha os dois campos!!!" , alert.getText() );
		alert.accept();
	}
	
	
	
}
