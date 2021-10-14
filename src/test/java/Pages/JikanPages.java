package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JikanPages {
	WebDriver driver;
	
	
		
		// elementos del landing page
		public By Caja_de_busqueda ;
		public By Boton_GO ;
		public By Requesting ;
		public By Request_cached ;
		public By Time_taken;
		public By Sponsors ;
		// elementos de la notificacion
		public By RealizarConsulta  ;
		
		public JikanPages(WebDriver driver) {
			this.driver = driver;	
			// elementos del landing page
			Caja_de_busqueda = By.id("search_query");
			Boton_GO = By.id("search");
			Requesting = By.id("search_query_url");
			Request_cached = By.id("request_cached");
			Time_taken = By.id("request_time_taken");
			Sponsors = By.xpath("/html/body/section[8]/div[1]/div/a");
			// elementos de la notificacion
			RealizarConsulta = By.id("back-submit");
					
		
		}	
}
