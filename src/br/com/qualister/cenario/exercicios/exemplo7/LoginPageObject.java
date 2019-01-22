package br.com.qualister.cenario.exercicios.exemplo7;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.qualister.core.WDS;

public class LoginPageObject {

	@FindBy(id = "usuariologin")
	private WebElement campoUsuario;

	@FindBy(id = "usuariosenha")
	private WebElement campoSenha;

	public static LoginPageObject deve() {
		return PageFactory.initElements(WDS.get(), LoginPageObject.class);
	}

	public void acessarAplicacao() {
		WDS.get().navigate().to("http://quickloja.qualister.info");
	}

	public void informarUsuario(String usuario) {
		campoUsuario.sendKeys(usuario);
	}

	public void informarSenha(String senha) {
		campoSenha.sendKeys(senha);
	}

	public void solicitarLogin() {
		campoSenha.submit();
	}
	
	public void logar(String usuario, String senha){
		acessarAplicacao();
		informarUsuario(usuario);
		informarSenha(senha);
		solicitarLogin();
	}

}
