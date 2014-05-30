package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class Navegacao {
	
	WebDriver driver;
	private static final String ROOT = "http://localhost:8080/curso-selenium";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveAbrirIndexENavegarPAraContador(){
		driver.get(ROOT + "/index.jsp");
		WebElement h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
		
		driver.navigate().to(ROOT + "/contador.jsp");
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
		
		driver.navigate().refresh();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
		
		driver.navigate().back();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
		
		driver.navigate().forward();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
	}
	
	@Test
	public void deveAbrirContadorEDarUmRefresh(){
		driver.get(ROOT + "/contador.jsp");
		WebElement h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
		
		driver.navigate().refresh();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
	}
	
	@Test
	public void deveAbrirIndexNavegarParaContadorERetornarParaIndex(){
		driver.get(ROOT + "/index.jsp");
		WebElement h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
		
		driver.navigate().to(ROOT + "/contador.jsp");
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
		
		driver.navigate().back();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
	}
	
	@Test
	public void deveAbrirIndexNavegarParaContadorERetornarParaIndexEDarUmFowardDeVoltaParaContador(){
		driver.get(ROOT + "/index.jsp");
		WebElement h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
		
		driver.navigate().to(ROOT + "/contador.jsp");
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
		
		driver.navigate().back();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("INDEX",  h1.getText() );
		
		driver.navigate().forward();
		h1 = By.tagName("h1").findElement(driver);
		assertEquals("CONTADOR",  h1.getText() );
	}
	
}
