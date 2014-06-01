package br.com.efraimgentil.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class ManipulandoJanelas {
	
	WebDriver driver;
	private static final String FRAMED_PAGE = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/frames/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get(FRAMED_PAGE);
	}
	
	@After
	public void destroy(){
//		driver.quit();
	}
	
	@Test
	public void ts(){
		driver.switchTo().frame("content");
		driver.findElement( By.partialLinkText("Selenium (googlecode)") ).click();
		
		List<String> janelas = new ArrayList<>( driver.getWindowHandles() );
		driver.switchTo().window( janelas.get(1) );
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[name='projectsearch']")).click();
//		driver.close();
		
		driver.switchTo().window( janelas.get(0) );
		driver.switchTo().frame("content");
		driver.findElement( By.partialLinkText("Selenium (googlecode)") ).click();
		
		janelas = new ArrayList<>( driver.getWindowHandles() );
		driver.switchTo().window( janelas.get(2) );
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[name='projectsearch']")).click();
	}
	
}
