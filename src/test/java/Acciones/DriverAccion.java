package Acciones;

import org.openqa.selenium.WebDriver;
import CommonFuntions.BaseTest;
import CommonFuntions.Navegador;


public class DriverAccion extends BaseTest {
	Navegador navegador;
	DriverAccion loginaccion;		
	BaseTest baseTest;
	
	public DriverAccion(WebDriver driver) {
		super(driver);
		navegador=new Navegador();
	}	
	
	public WebDriver iniciarSesion(String Url,String Navegador) {	
		
		try {
			driver  = navegador.SelecionarNavegadorUrl(Navegador,Url);
			baseTest = new BaseTest(driver);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return driver;
	}
	
	
	
		
	
}
