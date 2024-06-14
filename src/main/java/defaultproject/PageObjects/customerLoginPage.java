package defaultproject.PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class customerLoginPage extends AbstractComponents {
	WebDriver driver;

	public customerLoginPage(WebDriver driver) {
		super(driver); // super send to parent
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "pass")
	WebElement passwordField;
	// WM*k6cye4eY#K4U

	@FindBy(id = "send2")
	WebElement signInButton;

	@FindBy(css = ".counter.qty")
	WebElement basketCount;

	@FindBy(css = ".counter-label")
	WebElement counter;

	@FindBy(css = ".action.showcart")
	WebElement basketIcon;

	@FindBy(css = ".action.delete")
	WebElement deleteButton;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement okButton;

	@FindBy(id = "btn-minicart-close")
	WebElement closeButton;

	@FindBy(xpath = "//ol[@id='mini-cart']/li")
	List<WebElement> allCart;
	//

	By orderBy = By.id("email");

	By basket = By.cssSelector(".action.showcart");

	By okBy = By.xpath("//span[contains(text(),'OK')]");

	public void login(String email, String pwd) {

		waitForElementToAppear(orderBy);
		emailField.sendKeys(email);
		passwordField.sendKeys(pwd);
		signInButton.click();

	}

	public List<WebElement> getCart() {
		return allCart;
	}

	public void isBasketEmpty() throws InterruptedException {
		int i = 1;
		int i2 = allCart.size();
		if (i2 != 0) {
			while (i <= allCart.size() + 1) {
				Thread.sleep(Duration.ofSeconds(2));
				basketIcon.click();
				deleteButton.click();
				waitForElementToAppear(okBy);
				okButton.click();
				closeButton.click();
				i++;
			}
		}
	}
}
