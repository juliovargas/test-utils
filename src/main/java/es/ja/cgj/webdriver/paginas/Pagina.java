package es.ja.cgj.webdriver.paginas;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class Pagina {

	//private static final int DEFAULT_TIMEOUT = 10;
	protected final WebDriver driver;
	protected Wait<WebDriver> wait;

	public Pagina(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
		//this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
		PageFactory.initElements(driver, this);
	}

	/*public boolean isAlertPresent() {

		boolean presentFlag = false;

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			presentFlag = true;
			// if present consume the alert
			alert.accept();

		} catch (NoAlertPresentException ex) {
			// Alert not present
			ex.printStackTrace();
		}

		return presentFlag;
	}*/

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	} // isAlertPresent()
}
