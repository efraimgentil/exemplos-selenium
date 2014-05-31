package TrabalhandoComAlertas;

import static org.junit.Assert.assertEquals;

import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class AlertasJquery {
	
	
	WebDriver driver;
	final String PAGINA_FORMULARIO = "http://eliasnogueira.com/selenium/exercicios/fortaleza/webdriver/lista/alert_confirmation_js/";
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@After
	public void destroy(){
		driver.quit();
		driver.get(PAGINA_FORMULARIO);
	}
	
	@Test
	public void deveClicarOkNoAlert(){
		driver.findElement(By.id("alerta")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement alertOk = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.id("alertify-ok")) ));
		alertOk.click();
	}
	
	@Test
	public void deveClicarNaConfirmacaoECancelar(){
		driver.findElement(By.id("confirmacao")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement btnAlertCancel = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.id("alertify-cancel")) ));
		btnAlertCancel.click();
		
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertTrue("Deveria mostrar no log que usuário cancelou" , log.getText().contains("Você clicou em Cancelar!") );
	}
	
	@Test
	public void deveClicarNaConfirmacaoEClickarEmOk(){
		driver.findElement(By.id("confirmacao")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement btnAlertCancel = wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.id("alertify-ok")) ));
		btnAlertCancel.click();
		
		wait = new WebDriverWait(driver, 10);
		WebElement log = wait.until(ExpectedConditions.presenceOfElementLocated( By.cssSelector(".alertify-log-show") ) );
		assertTrue("Deveria mostrar no log que usuário cancelou" , log.getText().contains("Você clicou em OK!") );
	}
	
}
