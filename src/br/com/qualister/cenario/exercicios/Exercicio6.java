package br.com.qualister.cenario.exercicios;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class Exercicio6 {

	private String usuario;
	private String senha;
	private String nome;

	public Exercicio6(String usuario, String senha, String nome) {
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
	}

	@Test
	public void teste() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.get("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/lista/datadriven/");
			driver.findElement(By.id("login")).sendKeys(usuario);
			driver.findElement(By.id("senha")).sendKeys(senha);
			driver.findElement(By.id("senha")).submit();
			assertEquals("Bem vindo " + nome, driver.findElement(By.id("usuario")).getText());
		} finally {
			driver.close();
		}
	}

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "usuario01", "usuario01", "Usuario 01" },
				{ "usuario02", "usuario02", "Usuario 02" }, 
				{ "usuario03", "usuario03", "Usuario 03" },
				{ "usuario04", "usuario04", "Usuario 04" } });
	}
}
