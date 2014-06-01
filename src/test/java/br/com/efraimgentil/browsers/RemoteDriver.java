package br.com.efraimgentil.browsers;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriver {
	
	
	@Test
	public void acessoRemoto() throws MalformedURLException{
		String IP = "172.17.22.48";
		String URL = "http://" +  IP + ":4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver( new java.net.URL(URL) , DesiredCapabilities.firefox() );
		driver.get("http://www.google.com.br");
		WebElement busca = driver.findElement( By.id("gbqfq") );
		busca.sendKeys("Efraim Gentil");
		busca.sendKeys( Keys.RETURN );
		
	}
	
}
