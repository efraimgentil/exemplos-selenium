package br.com.efraimgentil.selenium;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class EsperaComMaisDeUmElemento {

	WebDriver driver;
	final String PAGINA_FORMULARIO = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/ajax_show/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveEsperarOsDoisElementosEstaremVisiveis(){
		driver.get(PAGINA_FORMULARIO);
		
		Select selectIdade = new Select( driver.findElement(By.id("idade")) );
		selectIdade.selectByValue("13");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		List<WebElement> elements = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy( 
						By.cssSelector("[name='nome_pais'], [name='email_pais'] , .atencao") )
				);
		
		assertSame( 3 , elements.size() );
	}
	
}
