package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import static org.junit.Assert.*;

public class RequisicaoAssincrona {
	
	WebDriver driver;
	private static final String ROOT = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/ajax_loading/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveFalharLoginEEsperarMensagem(){
		driver.get(ROOT);
		
		WebElement  login = driver.findElement(By.id("username"));
		WebElement senha = driver.findElement(By.id("password"));
		
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector("#message .error") ) );
		
		assertEquals("Usuario ou senhas invalidos." , message.getText());
	}
	
	@Test
	public void deveLancarMensageLogadoComSucessoEEscondeFormulario(){
		driver.get(ROOT);

		WebElement  login = driver.findElement(By.id("username"));
		WebElement senha = driver.findElement(By.id("password"));
		login.sendKeys("demo");
		senha.sendKeys("demo");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement message = wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector("#message .success") ) );

		assertEquals("Voce efetuou o login com sucesso!" , message.getText());
		assertFalse("Deve esconder formulario apos logar com sucesso"
				, driver.findElement(By.id("form1")).isDisplayed() );
		
	}
	
	
}
