package br.com.efraimgentil.aceitacao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class CadastroDeUsuarioAcceptance {

	WebDriver driver;
	final String PAGINA_CADASTRO_USUARIO = "http://localhost:8080/exemplos-selenium/cadastro-usuario";

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(PAGINA_CADASTRO_USUARIO);
	}

	@After
	public void destroy() {
		driver.quit();
	}

	@Test
	public void deveCadastrarUmNovoUsuarioComSucesso() {

		WebElement nomeUsuario = driver.findElement(By.id("nomeUsuario"));
		WebElement login = driver.findElement(By.id("login"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement senha = driver.findElement(By.id("senha"));
		
		nomeUsuario.sendKeys("Nome Usuario");
		login.sendKeys("loginUsuario");
		email.sendKeys("email@email.com");
		senha.sendKeys("senhaqualquer");
		
		driver.findElement( By.id("submit") ).click();
		
		assertTrue("Deve mostrar mensagem de cadastro com sucesso" ,
				driver.getPageSource().contains("Cadastro realizado com sucesso") );
	}
	
	@Test
	public void deveValidarCamposEMostrarMensagensDeErrorAoFalhar(){
		driver.findElement( By.id("submit") ).click();
		
		WebElement message = driver.findElement(By.id("message"));
		
		assertEquals("Não foi possivel cadastrar, verifique os dados informados", message.getText());
		
		WebElement errorLogin = driver.findElement(By.id("errorLogin"));
		WebElement errorNomeUsuario = driver.findElement(By.id("errorNomeUsuario"));
		WebElement errorSenha = driver.findElement(By.id("errorSenha"));
		WebElement errorEmail = driver.findElement(By.id("errorEmail"));
		
		assertEquals("Login deve ser preenchido" , errorLogin.getText() );
		assertEquals("Nome Usuário deve ser preenchido" , errorNomeUsuario.getText() );
		assertEquals("Senha deve ser preenchido" , errorSenha.getText() );
		assertEquals("Email deve ser preenchido" , errorEmail.getText() );
	}
	
	@Test
	public void deveValidarSenhaComMenosDe6Caracteres(){
		WebElement senha = driver.findElement(By.id("senha"));
		senha.sendKeys("senha");
		driver.findElement( By.id("submit") ).click();
		
		WebElement message = driver.findElement(By.id("message"));
		assertEquals("Não foi possivel cadastrar, verifique os dados informados", message.getText());
		WebElement errorSenha = driver.findElement(By.id("errorSenha"));
		assertEquals("Senha deve ter no minimo 6 caracteres" , errorSenha.getText() );
	}

}
