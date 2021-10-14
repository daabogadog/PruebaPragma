package StepsDefinitions;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import Acciones.DriverAccion;
import CommonFuntions.BaseTest;
import CommonFuntions.Navegador;

import cucumber.api.java.es.Dado;
;

public class NavegadorSteps {
	
	WebDriver driver;
	Logger log = Logger.getLogger(NavegadorSteps.class);	
	JikanSteps retanqueoasesorsteps;
	DriverAccion loginaccion;
	BaseTest baseTest;
	private List<String> Variables;
	static int a=0;
	
	public NavegadorSteps() {						
		this.driver=Navegador.driver;		
		loginaccion=new DriverAccion(driver);
	}
	
	@Dado("^Un usuario ingresa a la pagina de Jikan$")
	public void Unusuarioingresaalapaginaautomationpratice(List<String> Valores) throws Exception {

		this.Variables=Valores;		
		String Url=null;
		String Navegador=null;						
		Url=Variables.get(a);
		Navegador=Variables.get(a+1);		
		
		try {			
			driver = loginaccion.iniciarSesion(Url,Navegador);  //*********************************************************
			
		} catch (Exception e) {
			log.error("#ERROR###"+e);
			throw new Exception();
		}
	}

	

}
