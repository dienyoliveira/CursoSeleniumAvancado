package br.com.qualister.cenario.exercicios.exemplo7;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.qualister.core.CustomRunner;

@RunWith(CustomRunner.class)
public class CenarioInclusaoProduto {

	@Test
	public void testeInclusaoProduto() {
		LoginPageObject.deve().logar("elias.nogueira", "123");
		MenuPageObject.deve().acessarMenu("Gerenciar módulos->Produto");
		ListagemProdutoPageObject.deve().ClicarNovoProduto();
		InclusaoProdutoPageObject.deve().informarNomeProduto("produto 1");
	}
}
