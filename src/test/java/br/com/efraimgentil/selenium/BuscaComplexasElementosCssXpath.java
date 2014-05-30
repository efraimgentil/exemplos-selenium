package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class BuscaComplexasElementosCssXpath {

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
	public void deveEncontrarInputQueComeceComName(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement nome = driver.findElement( By.cssSelector("input[name^='name']"));
		
		assertEquals( "name-920" ,  nome.getAttribute("name") );
	}
	
	@Test
	public void deveEncontrarInputPasswordQueTermineComPassword(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement password = driver.findElement( By.cssSelector("input[name$='password']"));
		
		assertEquals( "632-password" ,  password.getAttribute("name") );
	}
	
	@Test
	public void deveEncontrarInputPassowrdQueTenhaPasswordNoMeio(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement password = driver.findElement( By.cssSelector("input[name*='-password-']"));
		
		assertEquals( "162-password-162" ,  password.getAttribute("name") );
	}
	
	@Test
	public void deveEncontrarInputQueComeceComNameComXpath(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement nome = driver.findElement( By.xpath("//input[starts-with(@name , 'name')]"));
		
		assertEquals( "name-920" ,  nome.getAttribute("name") );
	}
	
	@Test
	public void deveEncontrarInputPasswordQueTermineComPasswordComXpath(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement password = driver.findElement( By.xpath("//input[substring(@id , string-length(@id) - 8) = '-password']"));
		
		assertEquals( "632-password" ,  password.getAttribute("name") );
	}
	
	@Test
	public void deveEncontrarInputPassowrdQueTenhaPasswordNoMeioComXpath(){
		driver.get(ROOT + "pagina-complexa2.jsp");
		
		WebElement password = driver.findElement( By.xpath("//input[contains( @name , '-password-' ) ]"));
		
		assertEquals( "162-password-162" ,  password.getAttribute("name") );
	}
	
	
	
}
