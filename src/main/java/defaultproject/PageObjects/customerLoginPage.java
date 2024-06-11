package defaultproject.PageObjects;

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
	//WM*k6cye4eY#K4U
	
	@FindBy(id = "send2")
	WebElement signInButton;
	
	By orderBy = By.id("email");

	
	public void login(String email, String pwd) {
		
		waitForElementToAppear(orderBy);
		emailField.sendKeys(email);
		passwordField.sendKeys(pwd);
		signInButton.click();
		
	}
}
