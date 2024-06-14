package defaultproject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class placeOrderPage extends AbstractComponents{
	
	WebDriver driver;
	public placeOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action.primary.checkout")
	WebElement placeOrderButton;
	@FindBy(css = "#billing-address-same-as-shipping-checkmo")
	WebElement bAndS;
	@FindBy(id = "checkout-loader")
	WebElement loader;
	
	
	//By bAndS = By.cssSelector("#billing-address-same-as-shipping-checkmo");
	
	public void placeOrder() {
		waitForElementToDisappear(loader);
		boolean check = bAndS.isSelected();
		if(check = false) {
			bAndS.click();
		}
		placeOrderButton.click();
	}
}
