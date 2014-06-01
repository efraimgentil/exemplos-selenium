package br.com.efraimgentil.browsers;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComHtmlUnit {
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new HtmlUnitDriver();
	}
	
	
	@Test
	public void d(){
		driver.get("https://code.google.com/p/selenium/");
		
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[name='projectsearch']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until( ExpectedConditions.presenceOfElementLocated(By.id("serp")));
		
		driver.findElement(By.cssSelector("a[href='/p/selenium/']")).click();
	}
	
	
}
