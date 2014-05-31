package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class Frames {
	
	WebDriver driver;
	private static final String FRAMED_PAGE = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/frames/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get(FRAMED_PAGE);
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveIrNoMenuEClicarEmPaginaBranca(){
		driver.switchTo().frame("menu");
		
		driver.findElement(By.cssSelector("a[href='white.html']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		
		WebElement h1 = driver.findElement(By.tagName("h1"));
		
		assertEquals("Página branca" , h1.getText());
	}
	
	@Test
	public void deveIrNoMenuEClicarEmPaginaVerde(){
		driver.switchTo().frame("menu");
		
		driver.findElement(By.cssSelector("a[href='green.html']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("content");
		
		WebElement h1 = driver.findElement(By.tagName("h1"));
		
		assertEquals("Página verde" , h1.getText());
	}
	
	@Test
	public void deveIrNoTopNavEClicarEmMenu2(){
		driver.switchTo().frame("topNav");
		
		driver.findElement(By.cssSelector("a[href='menu_2.html']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("menu");
		
		WebElement h3 = driver.findElement(By.tagName("h3"));
		assertEquals("Menu 2" , h3.getText());
	}
	
	
}
