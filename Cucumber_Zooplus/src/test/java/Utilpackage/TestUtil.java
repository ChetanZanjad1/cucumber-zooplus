package Utilpackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;





public class TestUtil extends TestBase{

	static int PAGE_LOAD_TIMEOUT = 50;
	static int IMPLICIT_WAIT = 30;
	
	public static void clickMethodByJavaScript(WebElement Element) {
		JavascriptExecutor Executor = (JavascriptExecutor) driver;
		Executor.executeScript("arguments[0].click();", Element);
	}
	
	public static void waitForElement(WebElement Element1, WebElement Element2) {
		WebDriverWait wait=new WebDriverWait(driver, 40);
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
public static void waitUntilElementIsVisible(String xpath) {
	waitUntilElementIsVisible(xpath, TestBase.defaultTimeOutForObjectWait);
}
public static void waitUntilElementIsVisible(String xpath, int timeoutInSec) {
	try {
		Reporter__log("waitUntilElementIsVisible: For element with xpath \"" + xpath + "\"");
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	} catch (TimeoutException e) {
		Reporter__log("<div style='color:orange'><b>WARNING:</b><br />" + e.getMessage() + "</div><br />");
	}
}

public static void Reporter__log(String msg) {
	Reporter__log(msg, "");
}

public static void Reporter__log(String msg, String mode) {
	if (mode.equalsIgnoreCase("pass"))
		msg = "<span style='color:green'>" + msg + "</span>";
	else if (mode.equalsIgnoreCase("fail"))
		msg = "<span style='color:red'>" + msg + "</span>";
	else if (mode.equalsIgnoreCase("soft-fail"))
		msg = "<span style='color:orange'>" + msg + "</span>";
	else if (mode.equalsIgnoreCase("note"))
		msg = "<span style='color:blue'><b>" + msg + "</b></span>";
	// else, we have normal logging

	msg = msg + "<br />";
	Reporter.log(msg);
	msg = msg.replaceAll("<br.*?>", "\n").replaceAll("&nbsp;", " ").replaceAll("<p>", "\n\n")
			.replaceAll("</.*?>", "").replaceAll("<.*?>", "");
	System.out.println(msg);
}

public static void clickElementByJS(WebElement element) throws ElementNotLocatedOnUIException {
	Reporter__log("Attempting to click via JS..");
	if (waitForObject(element, TestBase.defaultTimeOutForObjectWait)) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		try {
			Reporter__log("Clicked successfully on WebElement via JS: " + element.getAttribute("outerHTML"));
		} catch (Exception e) {
			Reporter__log("Clicked successfully on WebElement via JS");
		}
	} else
		throw (new ElementNotLocatedOnUIException());

}

public static boolean waitForObject(WebElement element, int timeoutInSec) {
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
	try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		String elemOH = "";
		try {
			elemOH = element.getAttribute("outerHTML");
		} catch (Exception eOH) {
			elemOH = "~";
		}
		Reporter__log("Waited successfully for element with outerHTML: " + elemOH);
		return true;
	} catch (Exception e) {
		Reporter__log("<div style='color:red'>Waited unsuccessfully for WebElement</div>");
		String screenShot = getScreenshotPath(driver);
		Reporter__log("<br/><a href=\\" + screenShot + " target='_blank'>Click Here For Screenshot</a><br />");
		return false;
	}
}

public static String getScreenshotPath(WebDriver driver) {
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir") + "\\src\\test\\resources\\ErrorScreenshots\\"
			+ System.currentTimeMillis() + ".png";
	try {
		FileUtils.copyFile(src, new File(destination));
	} catch (IOException e) {
		e.printStackTrace();
	}
	return destination;
}

public static void click(String xpath) {
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

}
	
}
