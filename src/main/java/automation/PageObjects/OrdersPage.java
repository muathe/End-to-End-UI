package automation.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css ="div h1")
	WebElement visibilityOfText;
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productList;
	
	
	public boolean getOrderName(String productName) {
		waitForVisibility(visibilityOfText);
		boolean match = productList.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
		return match;
		
		
	}
	

}
