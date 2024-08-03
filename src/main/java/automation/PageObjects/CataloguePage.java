package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.AbstractComponents;

public class CataloguePage extends AbstractComponents {

	WebDriver driver;

	public CataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".card")
	List<WebElement> productList;

	@FindBy(css = ".card-body .fa-shopping-cart")
	WebElement cartAppear;

	@FindBy(css = "ngx-spinner")
	WebElement spinner;

	@FindBy(id = "toast-container")
	WebElement toast;

	@FindBy(xpath = "//li[4]/button[@class='btn btn-custom']")
	WebElement subCart;

	By list = By.cssSelector(".card b");

	By clickProduct = By.cssSelector(".card-body .fa-shopping-cart");

	public CartPage readProducts(String Shoes) {
		// By.cssSelector(".card b")
		waitForVisibility(cartAppear);
		WebElement product = productList.stream()
				.filter(products -> products.findElement(list).getText().equalsIgnoreCase(Shoes)).findFirst()
				.orElse(null);
		product.findElement(clickProduct).click();
		waitForInvisibility(spinner);
		waitForVisibility(toast);
		cartHeader(subCart);
		CartPage CartP = new CartPage(driver);
		return CartP;

	}

}
