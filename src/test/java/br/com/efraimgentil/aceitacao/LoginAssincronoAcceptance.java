package br.com.efraimgentil.aceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class LoginAssincronoAcceptance {
	
	WebDriver driver;
	final String PAGINA_LOGIN = "http://localhost:8080/exemplos-selenium/login";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveLogarComSucessoEMostrarMensagemDeSucesso(){
		driver.get(PAGINA_LOGIN);
		
		WebElement email = driver.findElement(By.id("email") );
		WebElement senha = driver.findElement(By.id("senha") );
		
		email.sendKeys("email@email.com");
		senha.sendKeys("senha");
		
		driver.findElement(By.id("submit")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		WebElement mensagemSucesso = wait.until( ExpectedConditions.presenceOfElementLocated( By.id("sucesso")));
		
		assertEquals("Usuário logado com sucesso", mensagemSucesso.getText() );
	}
	
	@Test
	public void deveFalharAoTentarLogarEMostrarMensagemDeErro(){
		driver.get(PAGINA_LOGIN);

		driver.findElement(By.id("submit")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10 );
		WebElement mensagemSucesso = wait.until( ExpectedConditions.presenceOfElementLocated( By.id("falha")));
		
		assertEquals("Login e/ou senha invalidos", mensagemSucesso.getText() );
	}
	
}
