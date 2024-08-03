package automate.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import automate.testcomponents.BaseTest;
import automate.testcomponents.Retry;
import automation.PageObjects.CartPage;
import automation.PageObjects.CataloguePage;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"purchase"},retryAnalyzer = Retry.class)
	public void loginErrorValidation() {

		lp.accountLogin("moe@hotmail.com", "1234");
		String message = lp.getErrorMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));
	}

	@Test(groups = {"purchase"})
	public void productErrorValidation() {
		CataloguePage cp = lp.accountLogin("moe@hotmail.com", "12345");
		CartPage CartP = cp.readProducts("ADIDAS ORIGINAL");
		boolean match = CartP.getNameOfProducts("ADIDAS ORIGINA");
		Assert.assertFalse(match);
	}

}
