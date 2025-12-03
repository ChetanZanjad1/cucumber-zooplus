package Utilpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import TestData.GetMethodFromFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	 static GetMethodFromFile prop=new GetMethodFromFile();
	public static WebDriver driver;
	public static String URL = "https://www.zooplus.ch";

	
	public static void setUp() throws Exception {
		System.out.println("BeforeClassSetup");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.get(URL);
		driver.get(prop.GetXpathFrompaymentDetails("URL"));
	

		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
	}

}
