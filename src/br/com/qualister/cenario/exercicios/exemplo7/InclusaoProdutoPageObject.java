package br.com.qualister.cenario.exercicios.exemplo7;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.qualister.core.WDS;

public class InclusaoProdutoPageObject {

	@FindBy(name = "produtonome")
	private WebElement campoNomeProduto;

	public static InclusaoProdutoPageObject deve() {
		return PageFactory.initElements(WDS.get(), InclusaoProdutoPageObject.class);
	}

	public void informarNomeProduto(String nomeProduto) {
		campoNomeProduto.sendKeys(nomeProduto);
	}
}
