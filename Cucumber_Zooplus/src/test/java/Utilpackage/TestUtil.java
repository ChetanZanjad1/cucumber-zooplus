package Utilpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase{

	static int PAGE_LOAD_TIMEOUT = 50;
	static int IMPLICIT_WAIT = 30;
	
	public static void clickMethodByJavaScript(WebElement Element) {
		JavascriptExecutor Executor = (JavascriptExecutor) driver;
		Executor.executeScript("arguments[0].click();", Element);
	}
	
	public static void waitForElement(WebElement Element1, WebElement Element2) {
		WebDriverWait wait=new WebDriverWait(driver, 100);
		Element2 =wait.until(ExpectedConditions.elementToBeClickable(Element1));
		Element2.click();
	}
	
	public static void verify_URL(String CurrentURL) {
		CurrentURL = driver.getCurrentUrl();
	}
	
public static void placeorder( ) {
	
	 WebElement checkbox = driver.findElement(By.xpath("//input[@data-zta='checkboxInput']"));
	if(checkbox.isEnabled()) {
		checkbox.click();
		System.out.println("Check box available on preview page");
	}else {
		System.out.println("Check box not available on preview page");
	}
	
}
	


	
}
