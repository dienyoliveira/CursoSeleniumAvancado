package br.com.qualister.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WDS {

	private static WebDriver driver = null;

	private static WebDriverWait wait = null;

	public static long DELAY = 0;

	public static String PATH_EVIDENCIAS = "";

	public static int TIMEOUT_EXPLICIT_WAIT = 15;

	public static WebDriver get() {
		if (driver == null) {
			//DesiredCapabilities dc = new DesiredCapabilities();
			//dc.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs\\bin\\phantomjs.exe");
			
			//driver = new PhantomJSDriver(dc);
			
			
			//driver = new HtmlUnitDriver(true);
			
			
			driver = new CustomFirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void finalizar() {
		// if (driver != null) {
		// while(getNumeroJanelas()>0){
		// WDS.get().switchTo().window(getUltimaJanela());
		// driver.close();
		// }
		// }
	}

	private static int getNumeroJanelas() {
		int contador = 0;
		String[] handles = new String[20];
		try {
			WDS.get().getWindowHandles().toArray(handles);
			for (String handle : handles) {
				if (handle != null) {
					contador++;
				}
			}
		} catch (UnreachableBrowserException e) {
		}
		return contador;
	}

	private static String getUltimaJanela() {
		String[] handles = new String[20];
		WDS.get().getWindowHandles().toArray(handles);
		int numeroJanelas = getNumeroJanelas();
		if (numeroJanelas > 0) {
			return handles[numeroJanelas - 1];
		} else {
			return null;
		}
	}

	public static WebDriverWait getWait() {
		if (wait == null) {
			wait = new WebDriverWait(get(), TIMEOUT_EXPLICIT_WAIT);
		}
		return wait;
	}

}
