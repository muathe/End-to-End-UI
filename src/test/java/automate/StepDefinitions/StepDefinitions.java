package automate.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import automate.testcomponents.BaseTest;
import automation.PageObjects.CartPage;
import automation.PageObjects.CataloguePage;
import automation.PageObjects.ConfirmationPage;
import automation.PageObjects.LandingPage;
import automation.PageObjects.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseTest {

	public LandingPage lp;
	public CataloguePage cp;
	public CartPage CartP;
	public PaymentPage pp;
	public ConfirmationPage ConfirmPage;

	@Given("^User is able to login with username (.+) and password (.+)$")
	public void User_is_able_to_login_with_username_and_password(String username, String password) throws IOException {

		lp = launchApplication();
		cp = lp.accountLogin(username, password);

	}

	@When("^User verifies the correct product (.+) is inside the cart$")
	public void User_verifies_the_correct_product_is_inside_the_cart(String productname) {
		CartP = cp.readProducts(productname);
		boolean match = CartP.getNameOfProducts(productname);
		Assert.assertTrue(match);

	}

	@And("^User can checkout the product with country (.+) (.+) name$")
	public void User_can_checkout_the_product_with_country_name(String fcountry, String scountry)
			throws InterruptedException {
		pp = CartP.checkOut();
		pp.selectCountry(fcountry);
		ConfirmPage = pp.checkOut(scountry);

	}

	@Then("{string} message should be displayed on the confirmation page")
	public void message_should_be_displayed_on_the_confirmation_page(String string) throws InterruptedException {

		String Confirmation = ConfirmPage.getConfirmationMessage();
		Assert.assertTrue(Confirmation.equalsIgnoreCase(string));

	}
	
	
	@Given("^User tries logging in with username (.+) and incorrect password (.+)$")
	public void User_tries_logging_in_with_username_and_incorrect_password(String username, String password) throws IOException {
		lp = launchApplication();
		lp.accountLogin(username, password);
		String message = lp.getErrorMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));

		
	}

}
