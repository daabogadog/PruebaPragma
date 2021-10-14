package StepsDefinitions;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import Acciones.JikanAccion;
import CommonFuntions.BaseTest;
import CommonFuntions.Navegador;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class JikanSteps {
	
	WebDriver driver;
	Logger log = Logger.getLogger(NavegadorSteps.class);	
	JikanAccion  Jikanpages;	
	BaseTest baseTest;
	
	public JikanSteps() {		
		//super(driver);
		this.driver = Navegador.driver;				
		Jikanpages = new JikanAccion(driver);		
	}
	
	@Cuando("El usuario ingresa el anime a buscar {string}")
	public void  Elusarioingresaelanimeabuscar(String Anime) throws InterruptedException {
		Jikanpages.Consult(driver, Anime);			
	}
	

	@Y("Presiona el boton de buscar")
	public void Presionaelbotondebuscar () throws InterruptedException {
		Jikanpages.Search(driver);		
	}
	

	@Y("Valida el resultado de la busqueda")
	public void Validaelresultadodelabusqueda() throws InterruptedException {
		assertTrue(Jikanpages.isHomePageDisplayed());
		assertTrue(Jikanpages.Request_true());
		Color ValidarColor = Jikanpages.ColorsElement(driver);
		assert ValidarColor.asRgb().equals("rgb(0, 255, 0)");
	}
	
	@Entonces("Valida es status de los link prensentes en la pagina")
	public void Validaesstatusdeloslinkprensentesenlapagina() throws InterruptedException {
		Jikanpages.chechingPageLink(driver);
	}
	
	
}
