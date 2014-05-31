package br.com.efraimgentil.selenium;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class TrabalhandoComAlertas {
	
	WebDriver driver;
	final String PAGINA_FORMULARIO = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/alert_confirmation/inc.auth.php";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
//	@Test
	public void deveClicarOkNoAlert(){
		driver.get(PAGINA_FORMULARIO);
		
		driver.findElement(By.id("submit")).click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Preencha os dois campos!!!" , alert.getText() );
		alert.accept();
	}
	
	@Test
	public void deveLogarComSucessoECadastrarUmUsuario(){
		driver.get(PAGINA_FORMULARIO);
		
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("pass");
		driver.findElement(By.id("submit")).click();
		
		driver.findElement(By.cssSelector("a[href='crud.php']")).click();
		
		driver.findElement(By.cssSelector("[name='nome']")).sendKeys("Efraim");
		driver.findElement(By.cssSelector("[name='sobrenome']")).sendKeys("Gentil");
		driver.findElement(By.cssSelector("[name='email']")).sendKeys("efraimgentil@gmail.com");
		driver.findElement(By.id("add_remove")).click();
		
		List<WebElement> tableLines = driver.findElements(By.cssSelector("table tr"));
		while( tableLines.size() > 1 ){
			WebElement webElement = tableLines.get(1);
			webElement.findElement(By.cssSelector("a[href*='crud.php?delete']")).click();
			driver.switchTo().alert().accept();
			
			tableLines= driver.findElements(By.cssSelector("table tr"));
		}
//		for (WebElement webElement : tableLines) {
////			if( webElement.getText().contains("Efraim") ){
//				webElement.findElement(By.cssSelector("a[href*='crud.php?delete']")).click();
//				driver.switchTo().alert().accept();
//				break;
////			}
//		}
		
	}
	
}
