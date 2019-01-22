package br.com.qualister.cenario.exercicios.exemplo7;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import br.com.qualister.core.WDS;

public class MenuPageObject {

	public static MenuPageObject deve() {
		return PageFactory.initElements(WDS.get(), MenuPageObject.class);
	}

	public void acessarMenu(String menu) {
		String[] menus = menu.split("->");
		for (String itemMenu : menus) {
			WDS.get().findElement(By.partialLinkText(itemMenu)).click();
		}
	}
}
