package br.com.qualister.cenario.exercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.qualister.core.CustomRunner;
import br.com.qualister.core.WDS;

@RunWith(CustomRunner.class)
public class Exercicio4 {

	@Test
	public void test() {
		
		WDS.get().navigate().to("http://quickloja.qualister.info/");
		WDS.get().findElement(By.id("usuariologin")).sendKeys("elias.nogueira");
		WDS.get().findElement(By.id("usuariosenha")).sendKeys("123");
		WDS.get().findElement(By.cssSelector(".btn-primary")).click();
		
		WebDriverWait wait = new WebDriverWait(WDS.get(), 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Gerenciar módulos")));
		
		WDS.get().findElement(By.partialLinkText("Gerenciar módulos")).click();
		WDS.get().findElement(By.linkText("Produto")).click();
		WDS.get().findElement(By.linkText("Novo produto")).click();
		WDS.get().findElement(By.linkText("Categorias")).click();
		
		Actions acao = new Actions(WDS.get());
		
		acao.clickAndHold(WDS.get().findElement(By.id("1"))).moveToElement(WDS.get().findElement(By.id("selecionadas"))).release().build().perform();
		assertEquals("Camisetas Video games",WDS.get().findElement(By.id("disponiveis")).getText());
		assertEquals("Tênis",WDS.get().findElement(By.id("selecionadas")).getText());

		acao.clickAndHold(WDS.get().findElement(By.id("2"))).moveToElement(WDS.get().findElement(By.id("selecionadas"))).release().build().perform();
		assertEquals("Video games",WDS.get().findElement(By.id("disponiveis")).getText());
		assertEquals("CamisetasTênis",WDS.get().findElement(By.id("selecionadas")).getText());
		
		acao.clickAndHold(WDS.get().findElement(By.id("1"))).moveToElement(WDS.get().findElement(By.id("disponiveis"))).release().build().perform();

		assertEquals("Video games Tênis",WDS.get().findElement(By.id("disponiveis")).getText());
		assertEquals("Camisetas",WDS.get().findElement(By.id("selecionadas")).getText());
}
}
