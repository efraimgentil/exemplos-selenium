package br.com.efraimgentil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class GoogleIt {
	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		//Instancia o FirefoxDriver para acessar o browser
		driver = new FirefoxDriver();
	}
	
	@After
	public void setDown(){
		//Fecha o browser
		driver.quit();
	}
	
	@Test
	public void test() throws InterruptedException{
		//Abre o browser e acessa a pagina
		driver.get("http://www.google.com");
		
		//Busca pelo elemento de id especificado
		WebElement f = By.id("gbqfq").findElement(driver);
		
		//Preenche o elemento com a informação especificada
		f.sendKeys("nintendo");
		//Tecla a tecla enter para envio automatico do form
		f.sendKeys(Keys.RETURN);
		
		//Deve esperar o retorno da requisição ajax para continuar
		WebDriverWait wait = new WebDriverWait( driver , 10);
		WebElement nintendoLink = wait.until(
						ExpectedConditions.presenceOfElementLocated( By.cssSelector("a[href*='.nintendo.']") ) );
		
		assertEquals( "http://www.nintendo.com/" , nintendoLink.getAttribute("href") );
	}
	
}
