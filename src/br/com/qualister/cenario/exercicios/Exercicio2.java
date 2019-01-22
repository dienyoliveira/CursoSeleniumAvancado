package br.com.qualister.cenario.exercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import br.com.qualister.core.CustomRunner;
import br.com.qualister.core.WDS;

@RunWith(CustomRunner.class)
public class Exercicio2 {

	@Test
	public void ctNavegaAvancado() {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Menu deslizante")).click();
		Actions acao = new Actions(WDS.get());
		acao.moveToElement(WDS.get().findElement(By.linkText("Treinamentos Qualister"))).build().perform();
		acao.moveToElement(WDS.get().findElement(By.partialLinkText("Automação"))).build().perform();
		acao.click(WDS.get().findElement(By.partialLinkText("Avançado"))).build().perform();
		WDS.get().switchTo().frame("contentFrame");
		assertEquals("CURSOS > AUTOMAÇÃO DE TESTES FUNCIONAIS COM SELENIUM - AVANÇADO", WDS.get().findElement(By.tagName("h3")).getText());
	}

	@Test
	public void ctNavegaFundamentos() {
		WDS.get().navigate().to("http://qualister.info/treinamentos/selenium/webdriver/exercicios/avancado/");
		WDS.get().findElement(By.linkText("Menu deslizante")).click();
		Actions acao = new Actions(WDS.get());
		acao.moveToElement(WDS.get().findElement(By.linkText("Treinamentos Qualister"))).build().perform();
		acao.moveToElement(WDS.get().findElement(By.partialLinkText("Automação"))).build().perform();
		acao.click(WDS.get().findElement(By.partialLinkText("Fundamentos"))).build().perform();
		WDS.get().switchTo().frame("contentFrame");
		assertEquals("CURSOS > AUTOMAÇÃO DE TESTES FUNCIONAIS COM SELENIUM - FUNDAMENTO", WDS.get().findElement(By.tagName("h3")).getText());
	}
}
