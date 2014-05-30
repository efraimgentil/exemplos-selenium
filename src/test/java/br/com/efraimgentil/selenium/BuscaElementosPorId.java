package br.com.efraimgentil.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class BuscaElementosPorId {
	
	WebDriver driver;
	private static final String ROOT = "http://localhost:8080/curso-selenium/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveEncontarEmailComValorPadrao(){
		driver.get(ROOT  + "formulario1.jsp" );
		
		WebElement email = driver.findElement( By.id("email") );
		
		String emailEsperado = "emailteste@gmail.com";
		assertEquals( emailEsperado , email.getAttribute("value")  );
	}
	
	@Test
	public void deveVirComBotaoLoginDesabilitadoPorPadrao(){
		driver.get(ROOT  + "formulario1.jsp" );
		
		WebElement btnSubmit = driver.findElement( By.id("submit") );
		
		String emailEsperado = "emailteste@gmail.com";
		assertFalse("Campo deveria vir desabilitado por default" , btnSubmit.isEnabled() );
	}
	
	@Test
	public void deveVirComOCheckboxLembrarSenhaMarcadoPorDefault(){
		driver.get(ROOT  + "formulario1.jsp" );
		
		WebElement checkboxLmebrarSenha = driver.findElement( By.id("lembrar") );
		
		assertTrue("Campo deveria vir checado por default" , checkboxLmebrarSenha.isSelected() );
	}
	
	@Test
	public void deveTerOAtributeSenhaSeguraEscondigo(){
		driver.get(ROOT + "formulario1.jsp" );
		
		WebElement senhaSegura = driver.findElement(By.id("senhaSegura") );
		
		assertFalse("Deveria estar escondigo" , senhaSegura.isDisplayed() );
	}
	
	@Test
	public void deveLimparSenhaAoClicarEmLimpar(){
		driver.get(ROOT + "formulario1.jsp" );
		
		WebElement senha = driver.findElement( By.id("senha") );
		WebElement btnLimpar = driver.findElement( By.id("limpar") );
		
		senha.sendKeys("senhablablabla");
		
		btnLimpar.click();
		
		assertTrue("Deveria limpar campo senha" , senha.getText().isEmpty() );
	}
	
	@Test
	public void deveHabilitarBotaoSubmitAposPReencherTodoOFormulario(){
		driver.get(ROOT + "formulario1.jsp" );
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement senha = driver.findElement(By.id("senha"));
		WebElement btnSubmit = driver.findElement(By.id("submit") );
		
		assertFalse("Deve iniciar desabilitado", btnSubmit.isEnabled() );
		
		email.clear();
		email.sendKeys("email@email.com");
		senha.sendKeys("senha");
		
		assertTrue("Deve habilitar apos preencher email e senha", btnSubmit.isEnabled() );
		
	}
	
	
}
