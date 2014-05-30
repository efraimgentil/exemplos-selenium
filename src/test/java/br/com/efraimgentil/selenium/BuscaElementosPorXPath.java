package br.com.efraimgentil.selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BuscaElementosPorXPath {
	
	WebDriver driver;
	private static final String ROOT = "http://localhost:8080/exemplos-selenium/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveEncontrarDivPai(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divpai = driver.findElement( By.xpath("//div") );
	}
	
	@Test
	public void deveEncontrarDivFilho(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divFilho = driver.findElement( By.xpath("//div/div") );
	}
	
	@Test
	public void deveEncontrarPrimeiraDivNeto(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divNeto = driver.findElement( By.xpath("//div/div/div[1]") );
		
		assertEquals( "Div Neto 1" , divNeto.getText().trim() );
	}
	
	@Test
	public void deveEcontrarSegundaDivNeto(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divNeto2 = driver.findElement( By.xpath("//div/div/div/div/div[2]") );
		assertEquals( "Div Neto 2" , divNeto2.getText().trim() );
	}

	@Test
	public void deveEncontrarInputTextDataInicio(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement dataInicio = driver.findElement( By.xpath("//*[@id='dataInicio']") ); 
	}
	
}
