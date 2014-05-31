package br.com.efraimgentil.selenium;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EsperaImplicita {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void esperaImplicita(){
		driver.get("http://www.google.com.br");
		
		//Espera 10 segundos por qualquer ação que não consiga executar diretamente
		driver.manage().timeouts().implicitlyWait( 10 , TimeUnit.SECONDS );
		
		//Como não ira achar o elemento "elemento" ira esperar 10 segundos
		WebElement elemento = driver.findElement(By.id("elemento"));
		
		
	}
	
}
