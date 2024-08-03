package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {

	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryInput;

	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> country;

	@FindBy(css = ".action__submit")
	WebElement submit;

	// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".action__submit"))));
	// String countryName = "Kingdom";
	// WebElement countryInput =
	// driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
	// Actions a1 = new Actions(driver);
	// a1.sendKeys(countryInput, "United").build().perform();

	// JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,800)");
	// Thread.sleep(1000);
	// List<WebElement> country =
	// driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
	// WebElement selectedCountry = country.stream().filter(c ->
	// c.getText().contains(countryName)).findFirst()
	// .orElse(null);
//	selectedCountry.click();

	// driver.findElement(By.cssSelector(".action__submit")).click();

	public void selectCountry(String partialText) throws InterruptedException {

		waitForVisibility(submit);
		Actions a1 = new Actions(driver);
		a1.sendKeys(countryInput, partialText).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(1000);

	}

	public ConfirmationPage checkOut(String countryName) {

		WebElement selectedCountry = country.stream().filter(c -> c.getText().contains(countryName)).findFirst()
				.orElse(null);
		selectedCountry.click();
		submit.click();
		ConfirmationPage ConfirmPage = new ConfirmationPage(driver);
		return ConfirmPage;


	}

}
