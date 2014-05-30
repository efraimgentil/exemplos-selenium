package br.com.efraimgentil.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbrindoBrowser {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void abrirFirefox(){
		driver.get("http://www.google.com.br");
	}
	
}
