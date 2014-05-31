package br.com.efraimgentil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RodandoNoMain {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://github.com/efraimgentil/exemplos-selenium/");
	}
	
}
