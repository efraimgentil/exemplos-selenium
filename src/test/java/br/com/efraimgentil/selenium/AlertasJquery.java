package br.com.efraimgentil.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertasJquery {
	
	WebDriver driver;
	final String PAGINA_FORMULARIO = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/alert_confirmation_js/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get(PAGINA_FORMULARIO);
	}
	
	@After
	public void destroy(){
		driver.quit();
	}
	
	@Test
	public void deveClicarOkNoAlert(){
		driver.findElement(By.id("alerta")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement message = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement( By.cssSelector("p.alertify-message") ) ) );
		assertEquals("Este é o exemplo de um alerta!", message.getText());
		
		driver.findElement(By.id("alertify-ok")).click(); 
	}
	
	@Test
	public void deveClicarNaConfirmacaoECancelar(){
		driver.findElement(By.id("confirmacao")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mensagemConfirmacao = wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.cssSelector("p.alertify-message") ) ) );
		
		assertEquals("Esta é uma caixa de confirmação" , mensagemConfirmacao.getText() );

		driver.findElement(By.id("alertify-cancel")).click();
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertTrue("Deveria mostrar no log que usuário cancelou" , log.getText().contains("Você clicou em Cancelar!") );
	}
	
	@Test
	public void deveClicarNaConfirmacaoEClickarEmOk(){
		driver.findElement(By.id("confirmacao")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mensagemConfirmacao = wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.cssSelector("p.alertify-message") ) ) );
		
		assertEquals("Esta é uma caixa de confirmação" , mensagemConfirmacao.getText() );

		driver.findElement(By.id("alertify-ok")).click();
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertTrue("Deveria mostrar no log que usuário cancelou" , log.getText().contains("Você clicou em OK!") );
	}
	
	
	@Test
	public void deveClicarNaPromtEClickarEmOk(){
		driver.findElement(By.id("prompt")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mensagemConfirmacao = wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.cssSelector("p.alertify-message") ) ) );
		
		assertEquals("Este é um exemplo do prompt" , mensagemConfirmacao.getText() );
		
		String messagem = "Minha mensagem";
		WebElement alertaInputText = driver.findElement(By.id("alertify-text"));
		alertaInputText.clear();
		alertaInputText.sendKeys( messagem );
		
		driver.findElement(By.id("alertify-ok")).click();
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertEquals( "Você clicou em OK e digitou: " + messagem , log.getText() );
	}
	
	
	@Test
	public void deveClicarNaPromtEClickarEmCancelar(){
		driver.findElement(By.id("prompt")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mensagemConfirmacao = wait.until( ExpectedConditions.visibilityOf(driver.findElement( By.cssSelector("p.alertify-message") ) ) );
		
		assertEquals("Este é um exemplo do prompt" , mensagemConfirmacao.getText() );

		driver.findElement(By.id("alertify-cancel")).click();
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertEquals( "Você clicou em Cancelar" , log.getText() );
	}
	
}
