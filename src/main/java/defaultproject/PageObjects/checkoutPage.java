package defaultproject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class checkoutPage extends AbstractComponents{
	
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By email = By.id("customer-email");
	By firstName = By.name("firstname");
	By lastName = By.name("lastname");
	By addLine1 = By.name("street[0]");
	By city = By.name("city");
	By state = By.name("region_id");
	By postcode = By.name("postcode");
	By country = By.name("country_id");
	By phoneNumber = By.name("telephone");
	//By loader = By.id("checkout-loader");
	@FindBy(id = "checkout-loader")
	WebElement loader;
	By flatRateRadioButton = By.cssSelector("input[value='flatrate_flatrate']");
	By tableRateRadioButton = By.cssSelector("input[value='tablerate_bestway']");
	By nextButton = By.cssSelector(".button.action.continue.primary");
	
	public void enterShipping(String emailAddr, String frstName, String lstName, String addr1, String cityAddr, String stateAddr, String postcodeAddr,
			String countryAddr, String phoneNumberAddr) {
		waitForElementToDisappear(loader);
		driver.findElement(firstName).clear();
		driver.findElement(firstName).sendKeys(frstName);
		driver.findElement(lastName).clear();
		driver.findElement(lastName).sendKeys(lstName);
		driver.findElement(addLine1).sendKeys(addr1);
		driver.findElement(city).sendKeys(cityAddr);
		driver.findElement(state).sendKeys(stateAddr);
		driver.findElement(postcode).sendKeys(postcodeAddr);
		driver.findElement(country).sendKeys(countryAddr);
		driver.findElement(phoneNumber).sendKeys(phoneNumberAddr);
		driver.findElement(tableRateRadioButton).click();
		driver.findElement(nextButton).click();
		
	}
	

}
