package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class BuscaElementosPorCssSelector {
		
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
		
		WebElement divpai = driver.findElement( By.cssSelector(".divpai") );
	}
	
	@Test
	public void deveEncontrarDivFilho(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divFilho = driver.findElement( By.cssSelector(".divfilho") );
	}
	
	@Test
	public void deveEncontrarPrimeiraDivNeta(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divNeto = driver.findElement( By.cssSelector(".divneto") );
		
		assertEquals( "Div Neto 1" , divNeto.getText().trim() );
	}
	
	@Test
	public void deveEcontrarSegundaDivNetaModoRobado(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divNeto2 = driver.findElement( By.cssSelector("div.divfilho div.divneto + div.divneto") );
		assertEquals( "Div Neto 2" , divNeto2.getText().trim() );
	}
	
	@Test
	public void deveEncontrarSegundaDivNetaComNthChild(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement divNeto2 = driver.findElement( By.cssSelector("div.divfilho div.divneto:nth-child(2)") );
		assertEquals( "Div Neto 2" , divNeto2.getText().trim() );
	}
	
	@Test
	public void deveEncontrarInputTextDataInicio(){
		driver.get(ROOT + "pagina-complexa.jsp");
		
		WebElement dataInicio = driver.findElement( By.cssSelector("#dataInicio") ); 
	}
	
}
