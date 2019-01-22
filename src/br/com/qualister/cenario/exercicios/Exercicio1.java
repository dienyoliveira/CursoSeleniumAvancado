package br.com.qualister.cenario.exercicios;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import br.com.qualister.core.CustomRunner;
import br.com.qualister.core.WDS;

@RunWith(CustomRunner.class)
public class Exercicio1 {

	@Test
	public void ctAlerta() {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Teclas de atalho")).click();
		WDS.get().findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		assertEquals("O alerta apareceu!", WDS.get().switchTo().alert().getText());
		WDS.get().switchTo().alert().accept();
	}

	@Test
	public void ctConfirmacao() {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Teclas de atalho")).click();
		WDS.get().findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.CONTROL, "c"));
		assertEquals("Esta é a confirmação!", WDS.get().switchTo().alert().getText());
		WDS.get().switchTo().alert().dismiss();
	}

	@Test
	public void ctPrompt() {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Teclas de atalho")).click();
		WDS.get().findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.ALT, "p"));
		assertEquals("Digite seu nome:", WDS.get().switchTo().alert().getText());
		WDS.get().switchTo().alert().sendKeys("Roberto");
		WDS.get().switchTo().alert().accept();
	}

	@Test
	public void ctJanela() throws IOException {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Teclas de atalho")).click();
		WDS.get().findElement(By.tagName("body")).sendKeys(Keys.chord(Keys.ALT, "j"));
		String[] handles = new String[5];
		WDS.get().getWindowHandles().toArray(handles);
		String handleElegivel = "";
		String handlePadrao = WDS.get().getWindowHandle();
		for (String handle : handles) {
			if (handle != null) {
				handleElegivel = handle;
			}
		}
		WDS.get().switchTo().window(handleElegivel);
		WDS.get().close();
		WDS.get().switchTo().window(handlePadrao);
	}

}
