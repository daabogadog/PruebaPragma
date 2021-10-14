package Acciones;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonFuntions.BaseTest;
import Pages.JikanPages;



public class JikanAccion extends BaseTest {
	
	WebDriver driver;	
	JikanPages  jikanpages;	

	public JikanAccion(WebDriver driver) {
		super(driver);
		jikanpages = new JikanPages(driver);
	}

	/************ INICIO ACCIONES ***************/
	
	//Metodo para consultar Anime
	public void Consult(WebDriver driver, String data) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(jikanpages.Caja_de_busqueda));
		type(data,jikanpages.Caja_de_busqueda);
		

	}
	
	public void Search(WebDriver driver) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		click(jikanpages.Boton_GO);
		wait.until(ExpectedConditions.visibilityOfElementLocated(jikanpages.Requesting));
		Thread.sleep(2000);		

	}
 
	//Metodo para verificar elemento presente en pantalla
	public boolean isHomePageDisplayed() {

		if (isDisplayed(jikanpages.Request_cached) && isDisplayed(jikanpages.Requesting) && isDisplayed(jikanpages.Time_taken)) {
			
				clear(jikanpages.Caja_de_busqueda);
				return true;				
		}

		else
			return false;
	}
	
	public boolean Request_true() {
       
		if (istext(jikanpages.Request_cached)!="false") {
			return true;				
		}
		else			
			return false;
	}
	
	
	
    //Metodo para verificar color de un elemento
	public Color ColorsElement(WebDriver driver) {

		Color ValidarColor = Color.fromString(driver.findElement((jikanpages.Request_cached)).getCssValue("color"));
		return ValidarColor;
	}

	
     //Metodo para verificar todos los link de una pagina
	public boolean chechingPageLink(WebDriver driver) {
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		String url = "";
		List<String> brokenLinks = new ArrayList<String>();
		List<String> OkLinks = new ArrayList<String>();

		HttpURLConnection httpConection = null;
		int responseCode = 200;
		Iterator<WebElement> it = Links.iterator();

		while (it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println(url + "url no configurada o vacia");
				continue;
			}
			try {
				httpConection = (HttpURLConnection) (new URL(url).openConnection());
				httpConection.setRequestMethod("HEAD");
				httpConection.connect();
				responseCode = httpConection.getResponseCode();

				if (responseCode > 400) {
					System.out.println("Error Link: -- " + url);
					brokenLinks.add(url);
				} else {
					System.out.println("Valido Link: -- " + url);
					OkLinks.add(url);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Links Validos: -- " + OkLinks.size());
		System.out.println("Links Invalidos: -- " + brokenLinks.size());

		if (brokenLinks.size() > 0) {
			System.out.println("**** ERROR ------------------- lINK ROTOS");
			for (int i = 0; i < brokenLinks.size(); i++) {
				System.out.println(brokenLinks.get(i));
			}
			return false;
		} else {
			return true;
		}

	}


	/************ FIN ACCIONES *****************/
	
	
    
}
