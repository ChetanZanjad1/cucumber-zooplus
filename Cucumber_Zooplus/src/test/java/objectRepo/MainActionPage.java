package objectRepo;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestData.GetMethodFromFile;
import Utilpackage.TestBase;
import Utilpackage.TestUtil;

public class MainActionPage extends TestUtil {
	GetMethodFromFile prop = new GetMethodFromFile();

	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
	private WebElement cookiesbanner;

	@FindBy(xpath = "//div[@id='header-category-links']/div[1]/ul/li[1]")
	private WebElement MenuHeader;

	@FindBy(xpath = "//div[@id='header-category-flyout']//li")
	private WebElement headerList;

	@FindBy(xpath = "(//button[@data-zta='quantityStepperIncrementButton'])[1]")
	private WebElement numberofproduct;

	@FindBy(xpath = "//button[@data-zta='SelectedArticleBox__AddToCartButton']")
	private WebElement addtocart;

	@FindBy(xpath = "//a[@data-zta='ButtonAnchorUIC']")
	private WebElement checkout;

	@FindBy(xpath = "//button[@data-zta='CartButtonUIC']")
	private WebElement checkout_Proceed;

	@FindBy(xpath = "//div[@data-testid='total-price-value']")
	private WebElement shipping_Cost;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement login_ID;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement login_Pass;

	@FindBy(xpath = "//button[@data-zta='btnSubmitCustomerSection']")
	private WebElement login_button;

	@FindBy(xpath = "//a[@id='gotoCheckoutPayment']")
	private WebElement Paymentchange;

	@FindBy(xpath = "//label[contains(@class, 'js-payment__label')]")
	private WebElement PaymentOptionList;

	@FindBy(xpath = "//input[@autocomplete='cc-number']")
	private WebElement ACardNumber;

	@FindBy(xpath = "//input[@id='holderName']")
	private WebElement ACardName;

	@FindBy(xpath = "//input[@id='encryptedExpiryMonth']")
	private WebElement AcardExpiryMonth;

	@FindBy(xpath = "//input[@id='encryptedExpiryYear']")
	private WebElement AcardExpiryyear;

	@FindBy(xpath = "//input[@id='encryptedSecurityCode']")
	private WebElement AcardCVV;

	@FindBy(xpath = "//button[@id='editPaymentSubmit']")
	private WebElement submitepayment;

	@FindBy(xpath = "//input[@id='credit-card-number']")
	private WebElement BCardNumber;

	@FindBy(xpath = "//input[@id='cardholder-name']")
	private WebElement BCardName;

	@FindBy(xpath = "//select[@id='expiration-month']")
	private WebElement BcardExpiryMonth;

	@FindBy(xpath = "//select[@id='expiration-year']")
	private WebElement BcardExpiryyear;

	@FindBy(xpath = "//input[@id='cvv']")
	private WebElement BcardCVV;

	@FindBy(xpath = "//div[@class='paypal-button-label-container']")
	private WebElement paypalSubmite;

	@FindBy(xpath = "//label[@for='payPal']")
	private WebElement paypal;

	@FindBy(xpath = "//button[@id='makeTheOrder']")
	private WebElement placeorder;

	@FindBy(xpath = "//button[@data-testid='cancel-transaction-button']")
	private WebElement IdealCancel;

	@FindBy(xpath = "//button[@data-testid='cancel-transaction-confirm-dialog-confirm']")
	private WebElement IdealcancelConfirm;

	@FindBy(xpath = "//button[@aria-label='Aktia']")
	private WebElement Aktia;

	@FindBy(xpath = "//button[@id='abortButton']")
	private WebElement popupclose;

	@FindBy(xpath = "//button[@id='cancel-payment']")
	private WebElement popupcloseconfirm;

	@FindBy(xpath = "//button[@icon='pi pi-arrow-left']")
	private WebElement twintcancel;

	@FindBy(xpath = "//button[@id='backOrCancelButton']")
	private WebElement dotpay_cancel;

	@FindBy(xpath = "//button[@id='confirmCancel']")
	private WebElement dotpay_back_to_shop;
	
	@FindBy(xpath = "//button[@id='blik-button primary extended']")
	private WebElement dotpay_back_to_cancel;
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement dotpay_back_to_orderpage;
	

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement kalrna_cancel;

	@FindBy(xpath = "//button[@id='payment-cancel-dialog-express__confirm']")
	private WebElement kalrna_last_cancel;

	@FindBy(xpath = "//input[@id='bancontactcard.cardNumber']")
	private WebElement bancontact_card_number;

	@FindBy(xpath = "//input[@id='bancontactcard.cardHolderName']")
	private WebElement bancontact_card_name;

	@FindBy(xpath = "//select[@id='bancontactcard.expiryMonth']")
	private WebElement bancontact_card_month;

	@FindBy(xpath = "//select[@id='bancontactcard.expiryYear']")
	private WebElement bancontact_card_year;

	public MainActionPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyURL() {
		String CurrentURL = driver.getCurrentUrl();
		System.out.println(CurrentURL);
		// Assert.assertEquals(CurrentURL, "https://www.zooplus.ch/");
	}

	public void homepage() throws Exception {

		System.out.println("user navigate to homepage");

	}

	public void navivgate_on_plp() throws Exception {
		// String xpath = "//div[@id='header-category-links']/div[1]/ul/li[1]";
		// WebElement project = driver.findElement(By.xpath(xpath));
		Actions a = new Actions(driver);
		a.moveToElement(MenuHeader).perform();
		Thread.sleep(2000);
		List<WebElement> Alltag = driver.findElements(By.xpath("//div[@id='header-category-flyout']//li"));
		for (WebElement all : Alltag) {
			String print = all.getText();
			System.out.println(print);
			if (all.getText().equalsIgnoreCase("Royal Canin Size")) {
				all.click();
				System.out.println("brand selected");
				break;
			}
		}
	}

	public void navivgate_on_pdp_by_selecting_random_product() {
		List<WebElement> PDP = driver.findElements(By.xpath("//a[@data-zta='product-image-anchor']"));
		System.out.println(PDP.size());
		for (WebElement all : PDP) {
			String print = all.getText();
			System.out.println(print);
		}
		Random random = new Random();
		int randomIndex = random.nextInt(PDP.size());

		// Retrieve the option at the randomly generated index and click on it
		WebElement randomOption = PDP.get(randomIndex);
		String selectedOptionText = randomOption.getText();
		System.out.println("Selected option: " + selectedOptionText);
		TestUtil.clickMethodByJavaScript(randomOption);
	}

	public void add_product_into_cart() throws Exception {

		numberofproduct.click();
		// TestUtil.clickMethodByJavaScript(numberofproduct);
		TestUtil.clickMethodByJavaScript(addtocart);
		TestUtil.clickMethodByJavaScript(checkout);
		Thread.sleep(2000);
	}

	public void enable_proceed_button_by_add_product_into_cart() throws Exception {
		// with procced button enable or not

		while (true) {
			// Verify element is enable or not

			String shippingCost = shipping_Cost.getText();
			System.out.println("Shipping cost: " + shippingCost);

			// Check if the element is enable
			if (checkout_Proceed.isEnabled()) {
				// Click the "Proceed" button
				// checkout_Proceed.click();
				TestUtil.clickMethodByJavaScript(checkout_Proceed);
				System.out.println("Clicked on Proceed button.");
				Thread.sleep(2000);
				break; // Exit the loop once the action is performed
			} else {
				// Click the number of products if checkout_Proceed is Disable

				// numberofproduct.click();
				TestUtil.clickMethodByJavaScript(numberofproduct);
				Thread.sleep(2000);
				System.out.println("Clicked on number of products button.");
			}
		}
	}

	public void login_with_valide_credential() throws Exception {

		String[] parts = prop.GetXpathFrompaymentDetails("URL").split("\\.");
		if (parts.length > 2) {
			// Join the parts after the second '.'
			String result = String.join(".", java.util.Arrays.copyOfRange(parts, 2, parts.length));
			System.out.println(result);
			String login_credential_ID = "tester-tech@zooplus.";
			System.out.println(login_credential_ID + result);
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(login_credential_ID + result);
			// login_ID.sendKeys(login_credential_ID + result);
			Thread.sleep(2000);
		} else {
			System.out.println("The string doesn't have enough parts to split.");
		}

		// String login_credential_Pass = "penguin0!";
		login_Pass.sendKeys(prop.GetXpathFrompaymentDetails("login_credential_Pass"));
		Thread.sleep(2000);
		// login_button.click();
		TestUtil.clickMethodByJavaScript(login_button);
		Thread.sleep(5000);
	}

	public void edit_payment() throws InterruptedException, Exception {

		// Paymentchange.click();
		TestUtil.clickMethodByJavaScript(Paymentchange);
		List<WebElement> paymentOption = driver
				.findElements(By.xpath("//label[contains(@class, 'accordion__label')]"));
		System.out.println(paymentOption.size());
		for (WebElement all : paymentOption) {
			String print = all.getAttribute("for");
			System.out.println(print);
			Thread.sleep(2000);
			if (print.equalsIgnoreCase(prop.GetXpathFrompaymentDetails("payment_method"))) {
				 all.click();
				System.out.println("payment method selected" + all );
				break;
			}
		}


		// TestUtil.clickMethodByJavaScript(submitepayment);
	}

	public void place_order(WebDriver driver) throws InterruptedException, Exception {
		if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("adyenCreditCard")) {
			// obj.clickElement(prop.GetXpathFromITxpath("CC"));
			driver.switchTo().frame(0);
			// obj.typeInElement(prop.GetXpathFromITxpath("ACardNumber"),
			// prop.GetXpathFrompaymentDetails("CC_Number"));
			driver.findElement(By.xpath("//input[@autocomplete='cc-number']"))
					.sendKeys(prop.GetXpathFrompaymentDetails("CC_Number"));

			// ACardNumber.sendKeys(prop.GetXpathFrompaymentDetails("CC_Number"));)
			driver.switchTo().defaultContent();

			ACardName.sendKeys(prop.GetXpathFrompaymentDetails("cc_holderName"));

			driver.switchTo().frame(1);
			AcardExpiryMonth.sendKeys(prop.GetXpathFrompaymentDetails("CC_MonthExpiry"));
			driver.switchTo().defaultContent();

			driver.switchTo().frame(2);
			AcardExpiryyear.sendKeys(prop.GetXpathFrompaymentDetails("CC_MonthYear"));
			driver.switchTo().defaultContent();

			driver.switchTo().frame(3);
			AcardCVV.sendKeys(prop.GetXpathFrompaymentDetails("CC_CVV"));
			driver.switchTo().defaultContent();

			TestUtil.clickMethodByJavaScript(submitepayment);
			Thread.sleep(5000);
			TestUtil.clickMethodByJavaScript(placeorder);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("braintreeCreditCard")) {
			// obj.clickElement(prop.GetXpathFromITxpath("braintreeCreditCard"));
			WebElement iframeNumber = driver.findElement(By.xpath("//iframe[@id='braintree-hosted-field-number']"));
			driver.switchTo().frame(0);
			System.out.println("inside ifram umber");
			BCardNumber.sendKeys(prop.GetXpathFrompaymentDetails("BCC_Number"));
			driver.switchTo().defaultContent();

			WebElement iframeName = driver
					.findElement(By.xpath("//iframe[@id='braintree-hosted-field-cardholderName']"));
			driver.switchTo().frame(1);
			BCardName.sendKeys(prop.GetXpathFrompaymentDetails("cc_holderName"));
			driver.switchTo().defaultContent();

			driver.switchTo().frame(2);
			// WebElement month =
			// driver.findElement(By.xpath(prop.GetXpathFromITxpath("BcardExpiryMonth")));
			Actions m = new Actions(driver);
			m.moveToElement(BcardExpiryMonth).perform();
			m.click().perform();
			for (int i = 0; i <= 6; i++) {
				Thread.sleep(2000);
				m.sendKeys(Keys.ARROW_DOWN).perform();
			}
			m.sendKeys(Keys.ENTER).perform();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(3);
			// WebElement year =
			// driver.findElement(By.xpath(prop.GetXpathFromITxpath("BcardExpiryyear")));
			Actions y = new Actions(driver);
			y.moveToElement(BcardExpiryyear).perform();
			y.click().perform();
			for (int i = 0; i <= 6; i++) {
				Thread.sleep(2000);
				y.sendKeys(Keys.ARROW_DOWN).perform();
			}
			y.sendKeys(Keys.ENTER).perform();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(4);
			BcardCVV.sendKeys(prop.GetXpathFrompaymentDetails("CC_CVV"));
			// obj.typeInElement(prop.GetXpathFromITxpath("BcardCVV"),
			// prop.GetXpathFrompaymentDetails("CC_CVV"));
			driver.switchTo().defaultContent();

			TestUtil.clickMethodByJavaScript(submitepayment);
			Thread.sleep(3000);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("PayPal")) {
            TestUtil.clickMethodByJavaScript(submitepayment);
            TestUtil.placeorder();
			// TestUtil.waitUntilElementIsClickable(paypalSubmite, 20);
            WebElement iFrame = driver.findElement(By.xpath("//iframe[@title='PayPal-paypal']"));
            System.out.println("changing frame" + iFrame);
			driver.switchTo().frame(iFrame);
			Thread.sleep(2000); 
			TestUtil.clickMethodByJavaScript(paypalSubmite);
			Thread.sleep(2000);
			System.out.println("after click");
			String mainWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			System.out.println(allWindows);
			Iterator<String> iterator = allWindows.iterator();
			// Here we will check if child window has other child windows and will fetch the
			// heading of the child window
			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					System.out.println("focoused on child browser");

				}
			}
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("ideal")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			//TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.placeorder();
			Thread.sleep(2000);
			TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.clickMethodByJavaScript(IdealCancel);
			TestUtil.clickMethodByJavaScript(IdealcancelConfirm);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("prePay")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			//TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("paytrail")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.clickMethodByJavaScript(Aktia);
			TestUtil.clickMethodByJavaScript(popupclose);
		//	TestUtil.clickMethodByJavaScript(popupcloseconfirm);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("Rechnugn")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("twint")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.waitUntilElementIsClickable(prop.GetXpathFromITxpath("placeorder"), 20);
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
		//	TestUtil.clickMethodByJavaScript(placeorder);
			Thread.sleep(2000);
			TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.clickMethodByJavaScript(twintcancel);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("cd")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("bancontact")) {

			// obj.clickElement(prop.GetXpathFromITxpath("bancontactcard"));
WebElement iFrame1 = driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[1]"));
			driver.switchTo().frame(iFrame1);
			bancontact_card_number.sendKeys(prop.GetXpathFrompaymentDetails("BCC_Number"));
			// obj.typeInElement(prop.GetXpathFromITxpath("bancontact_card_number"),
			// prop.GetXpathFrompaymentDetails("BCC_Number"));
			driver.switchTo().defaultContent();
			
			bancontact_card_name.sendKeys(prop.GetXpathFrompaymentDetails("cc_holderName"));
			WebElement iFrame2 = driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[2]"));
			driver.switchTo().frame(iFrame2);
			// WebElement month =
			// driver.findElement(By.xpath(prop.GetXpathFromITxpath("bancontact_card_month")));
			Actions m = new Actions(driver);
			m.moveToElement(bancontact_card_month).perform();
			m.click().perform();
			for (int i = 0; i <= 3; i++) {
				Thread.sleep(2000);
				m.sendKeys(Keys.ARROW_DOWN).perform();
			}
			m.sendKeys(Keys.ENTER).perform();
			driver.switchTo().defaultContent();
			WebElement iFrame3 = driver.findElement(By.xpath("(//iframe[@class='js-iframe'])[3]"));
			driver.switchTo().frame(iFrame3 );
			// WebElement year =
			// driver.findElement(By.xpath(prop.GetXpathFromITxpath("bancontact_card_year")));
			Actions y = new Actions(driver);
			y.moveToElement(bancontact_card_year).perform();
			y.click().perform();
			for (int i = 0; i <= 7; i++) {
				Thread.sleep(2000);
				y.sendKeys(Keys.ARROW_DOWN).perform();
			}
			y.sendKeys(Keys.ENTER).perform();
			driver.switchTo().defaultContent();

			TestUtil.clickMethodByJavaScript(submitepayment);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("onlineBankingPl")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.clickMethodByJavaScript(dotpay_cancel);
			Thread.sleep(2000);
			TestUtil.clickMethodByJavaScript(dotpay_back_to_shop);
			Thread.sleep(2000);
			TestUtil.clickMethodByJavaScript(dotpay_back_to_cancel);
			//TestUtil.click("dotpay_back_to_cancel");
			TestUtil.waitUntilElementIsVisible("dotpay_back_to_orderpage");
			TestUtil.clickMethodByJavaScript(dotpay_back_to_orderpage);
		
		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("klarnaLater")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			
			//TestUtil.clickMethodByJavaScript(submitepayment);
			
			TestUtil.placeorder();
			// TestUtil.clickMethodByJavaScript(placeorder);
			/*
			 * WebElement checkbox =
			 * driver.findElement(By.xpath("//input[@data-zta='checkboxInput']")); if
			 * (checkbox.isEnabled()) { checkbox.click();
			 * System.out.println("Check box available on preview page"); } else {
			 * System.out.println("Check box not available on preview page"); }
			 */
			TestUtil.clickMethodByJavaScript(placeorder);
			 
			
			TestUtil.clickMethodByJavaScript(kalrna_cancel);
			TestUtil.clickMethodByJavaScript(kalrna_cancel);
			//TestUtil.clickMethodByJavaScript(kalrna_last_cancel);

		} else if (prop.GetXpathFrompaymentDetails("payment_method").equalsIgnoreCase("klarnaOvertime")) {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			// obj.clickElement(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(submitepayment);
			TestUtil.placeorder();
			TestUtil.clickMethodByJavaScript(placeorder);
			TestUtil.clickMethodByJavaScript(kalrna_cancel);
			TestUtil.clickMethodByJavaScript(kalrna_last_cancel);

		} else {
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("placeorder"));
			TestUtil.clickMethodByJavaScript(placeorder);
			// obj.waitUntilElementIsVisible(prop.GetXpathFromITxpath("orderno"));

		}
	}
}
