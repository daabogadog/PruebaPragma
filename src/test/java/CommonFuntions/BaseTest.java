package CommonFuntions;


import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BaseTest {

	public WebDriver driver;
	private static Properties pro = new Properties();	

	public BaseTest(WebDriver driver) {
		this.driver = driver;
		
	}
	/*********** INICIO FUNC BASICAS SELENIUM ******************/
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void clear(By locator) {
		driver.findElement(locator).clear();;
	}
	
	public Boolean isDisplayed(By locator) {
		
		try {
			return driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public String istext(By locator) {
		String a =driver.findElement(locator).getText();
		return a;
	}
	
	/*********** FIN FUNC BASICAS SELENIUM ******************/
	
	public void Clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void LimpiarConTeclado (By locator) {
		 driver.findElement(locator).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
	}
	
	public void EscribirElemento(By locator, String texto) {
		driver.findElement(locator).sendKeys(texto);
	}

	public void hacerClick(By locator) {
		driver.findElement(locator).click();
	}

	public String TextoElemento(By locator) {
		return driver.findElement(locator).getAttribute("value");
	}
	
	public Boolean assertEstaPresenteElemento (By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
			}catch (Exception e) {
			return false;
		}
		
	}
	
	public void assertvalidarEquals (String a, String b) {
		assertEquals(a,b);
	}
	
	public void selectByVisibleText (By locator, String valor) {
		
		Select se = new Select(driver.findElement(locator));
		se.selectByVisibleText(valor);
		;
	}
		
		
	public void EnviarEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}
	
		
	/*********** FIN FUNC BASICAS SELENIUM ******************/	
	
	/************* FUNC Assert Selenium ****************/
	public void assertTextoelemento (By locator, String Comparar) {
		
		 assertEquals(driver.findElement(locator).getText(),Comparar);
			
		}

	public void BuscarTextoPage(String Texto) {
		String pageText = driver.findElement(By.tagName("body")).getText();
		assertThat("Texto no encontrado", pageText, containsString(Texto));

	}	
	
	/************* FIN FUNC Assert Selenium ****************/
	

	/************ INICIO FUNC JAVASCRIPT ************/
	public void hacerScrollAbajo() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10)");
	}
	
	//metodo que usa JavaScrip para hacer Scroll
	public void Hacer_scroll(By locator) throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Element = driver.findElement(locator);
			js.executeScript("arguments[0].scrollIntoView();", Element);
		}

	
	/************ FIN FUNC JAVASCRIPT ************/

	/************ INICIO DE ESPERAS ************/
	public void esperaExplicita(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void esperaExplicitaTexto(String texto) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"),texto));

	}
	
	public void esperaExplicitaNopresente(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	

    
}
