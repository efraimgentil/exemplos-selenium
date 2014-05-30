package br.com.efraimgentil.browsers;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTestCase {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void abrirFirefox(){
		driver.get("http://www.armandocouto.com.br");
	}
	
}
