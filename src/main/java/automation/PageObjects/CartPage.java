package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "li button[class*='btn-primary']:last-child")
	WebElement checkOut;

	@FindBy(css = ".cartSection h3")
	List<WebElement> nameOfProducts;

	public boolean getNameOfProducts(String Shoes) {

		waitForVisibility(checkOut);
		boolean match = nameOfProducts.stream().anyMatch(name -> name.getText().equalsIgnoreCase(Shoes));
		return match;
	}

	public PaymentPage checkOut() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		checkOut.click();
		PaymentPage pp = new PaymentPage(driver);
		return pp;

	}

}
