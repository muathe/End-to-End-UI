package automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement toastMessage;
	
	@FindBy(id = "toast-container")
	WebElement Message;

	public CataloguePage accountLogin(String username, String password) {
		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		login.click();
		CataloguePage cp = new CataloguePage(driver);
		return cp;
	}

	public void getURL() {
		driver.get("https://rahulshettyacademy.com/client/");

	}
	
	
	public String getErrorMessage() {
		waitForVisibility(Message);
		String message = toastMessage.getText();
		return message;
	}

}
