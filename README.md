Exemplos-selenium
=================

Projeto contendo exemplos de uso do framework selenium para automatização de testes de aceitação. 

## Como começar a usar o sellenium?
Em um projeto java com maven no gerencimaneto de dependencias adicione a seguinte dependencia.
```xml
<dependency>
  	<groupId>org.seleniumhq.selenium</groupId>
	<artifactId>selenium-java</artifactId>
	<version>2.42.1</version>
</dependency>  
```
Com a dependencia devidamente configurada você já pode utilizar o selenium em uma classe por meio de metodo main, ou de preferencia em suas classes de teste

Em um metodo main:
```java
public static void main(String[] args) {
	WebDriver driver = new FirefoxDriver();
		
	driver.get("https://github.com/efraimgentil/exemplos-selenium/");
}
```

Em um metodo de teste (jUnit ou TestNG:
```java
@Test
public void abrirFirefox(){
	WebDriver driver = new FirefoxDriver();
		
	driver.get("https://github.com/efraimgentil/exemplos-selenium/");
}
```
