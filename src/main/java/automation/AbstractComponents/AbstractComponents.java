package automation.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.PageObjects.OrdersPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="[routerlink='/dashboard/myorders']")
	WebElement orderHeader;

	public void waitForInvisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

	public void waitForVisibility(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(ele));

	}

	public void cartHeader(WebElement subCart) {
		subCart.click();

	}
	
	public OrdersPage orderHeader() {
		orderHeader.click();
		OrdersPage op = new OrdersPage(driver);
		return op;

	}

}
