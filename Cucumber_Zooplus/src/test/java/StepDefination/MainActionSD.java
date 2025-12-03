package StepDefination;

import Utilpackage.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.MainActionPage;

public class MainActionSD extends TestBase {

	//public static String URL = "https://www.zooplus.fr";

	MainActionPage MAP = new MainActionPage();

	@Given("launch browser")
	public void launch_browser() throws Exception {
		TestBase.setUp();
	}
	@When("user is on zooplus dashboard")
	public void user_is_on_zooplus_dashboard() {
		MAP.verifyURL();
	}
	@Then("user navigate to homepage")
	public void user_navigate_to_homepage() throws Exception {
		MAP.homepage();
	}

	
	@Given("user on homepage")
	public void user_on_homepage() {
		System.out.println("user on home page");
	}
	@When("user trying to Navivgate on PLP")
	public void user_trying_to_navivgate_on_plp() throws Exception {
		MAP.navivgate_on_plp();
	}
	@Then("user navigate to PLP")
	public void user_navigate_to_plp() {
		System.out.println("user navigate to PLP");
	}

	
	@Given("user on PLP")
	public void user_on_plp() {
		System.out.println("user is on PLP");
	}
	@When("user trying to Navivgate on PDP by selecting random product")
	public void user_trying_to_navivgate_on_pdp_by_selecting_random_product() {
		MAP.navivgate_on_pdp_by_selecting_random_product();
	}
	@Then("user navigate to PDP")
	public void user_navigate_to_pdp() {
		System.out.println("user navigate to PDP");
	}

	
	@Given("user is on PDP")
	public void user_is_on_PDP() {
		System.out.println("user is on PDP");
	}
	@When("user trying to add product into cart")
	public void user_trying_to_add_product_into_cart() throws Exception {
		MAP.add_product_into_cart();
	}
	@Then("user able to added product")
	public void user_able_to_added_product() {
		System.out.println("user able to add product");
	}

	
	@Given("user is on checkout overview")
	public void user_is_on_checkout_overview() {
		System.out.println("user can check proceed button enable or not");
	}
	@When("user trying to enable proceed button by add product into cart")
	public void user_trying_to_enable_proceed_button_by_add_product_into_cart() throws Exception {
		MAP.enable_proceed_button_by_add_product_into_cart();
	}
	@Then("user can see proceed button enable")
	public void user_can_see_proceed_button_enable() {
		System.out.println("user can seen proceed button enable ");
	}

	
	@Given("user is on checkout overview for login")
	public void user_is_on_checkout_overview_for_login() {
		System.out.println("user is on checkout overview for login");
	}
	@When("user trying to login with valide credential")
	public void user_trying_to_login_with_valide_credential() throws Exception {
		MAP.login_with_valide_credential();
	}
	@Then("user sucessfully login")
	public void user_sucessfully_login() {
		System.out.println("user sucessfully login with valide credential");
	}
	
	
	@Given ("user is on checkout preview page")
	public void user_is_on_checkout_preview_page() {
		System.out.println("user is on checkout preview page");
	}
    @When ("user trying to change payment method")
    public void user_trying_to_change_payment_method() throws Exception {
    	MAP.edit_payment();
    }
    @Then ("user sucessfully changed payment method")
    public void user_sucessfully_changed_payment_method() {
    	System.out.println("user sucessfully changed payment method");
    }
    
    
    @Given ("user changed payment method")
    public void user_changed_payment_method() {
    	System.out.println("user changed payment method");
    }
    @When ("user trying to place order")
    public void user_trying_to_place_order() throws Exception {
    	MAP.place_order(driver);
    }
    @Then ("user sucessfully place order and navigate to order finish page")
    public void user_sucessfully_place_order_and_navigate_to_order_finish_page() {
    	System.out.println("user sucessfully place order and navigate to order finish page");
    }
}
