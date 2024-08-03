package automate.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automate.testcomponents.BaseTest;
import automation.Data.DataReader;
import automation.PageObjects.CartPage;
import automation.PageObjects.CataloguePage;
import automation.PageObjects.ConfirmationPage;
import automation.PageObjects.OrdersPage;
import automation.PageObjects.PaymentPage;

public class TestPage extends BaseTest {

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// CataloguePage
		CataloguePage cp = lp.accountLogin(input.get("Email"), input.get("Password"));
		CartPage CartP = cp.readProducts(input.get("ProductName"));
		boolean match = CartP.getNameOfProducts(input.get("ProductName"));
		Assert.assertTrue(match);

		// PaymentPage
		PaymentPage pp = CartP.checkOut();
		pp.selectCountry("United");

		// ConfirmationPage
		ConfirmationPage ConfirmPage = pp.checkOut("Kingdom");
		String Confirmation = ConfirmPage.getConfirmationMessage();
		Assert.assertTrue(Confirmation.equalsIgnoreCase("thankyou for the order."));

	}

	@Test()
	public void orderRun() {
		CataloguePage cp = lp.accountLogin("moe@hotmail.com", "12345");
		OrdersPage op = cp.orderHeader();
		boolean matches = op.getOrderName("ADIDAS ORIGINAL");
		Assert.assertTrue(matches);
		System.out.println("order run success!");

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		DataReader dr = new DataReader();
		List<HashMap<String, String>> data = dr.getJsonData(System.getProperty("user.dir") + "\\src\\main\\java\\automation\\Data\\PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) } };

	}

}

/*
 * OR
 * 
 * return new Object[][]{ {"moe@hotmail.com", "12345", "ZARA COAT 3"},
 * {"moema@hotmail.com", "123456", "IPHONE 13 PRO"}, {"mike@hotmail.com",
 * "1234567", "ADIDAS ORIGINAL"} };
 */

//OR

/*
 * HashMap<String, String> map = new HashMap<String, String>();
 * 
 * map.put("Email", "moe@hotmail.com"); map.put("Password", "12345");
 * map.put("productName", "Zara Coat 3");
 * 
 * HashMap<String, String> map2 = new HashMap<String, String>();
 * 
 * map2.put("Email", "moema@hotmail.com"); map2.put("Password", "123456");
 * map2.put("productName", "IPHONE 13 PRO");
 * 
 * HashMap<String, String> map3 = new HashMap<String, String>();
 * 
 * map3.put("Email", "mike@hotmail.com"); map3.put("Password", "1234567");
 * map3.put("productName", "ADIDAS ORIGINAL");
 * 
 */
