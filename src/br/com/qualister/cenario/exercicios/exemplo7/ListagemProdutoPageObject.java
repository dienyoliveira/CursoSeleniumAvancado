package br.com.qualister.cenario.exercicios.exemplo7;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.qualister.core.WDS;

public class ListagemProdutoPageObject {

	@FindBy(partialLinkText = "Novo produto")
	private WebElement botaoNovoProduto;

	public static ListagemProdutoPageObject deve() {
		return PageFactory.initElements(WDS.get(), ListagemProdutoPageObject.class);
	}

	public void ClicarNovoProduto() {
		botaoNovoProduto.click();
	}
}

