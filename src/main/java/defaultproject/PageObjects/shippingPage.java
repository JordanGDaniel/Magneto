package defaultproject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class shippingPage extends AbstractComponents {

	WebDriver driver;

	public shippingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "customer-email")
	WebElement email;
	@FindBy(name = "firstname")
	WebElement firstName;
	@FindBy(name = "lastname")
	WebElement lastName;
	@FindBy(name = "street[0]")
	WebElement addLine1;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "region_id")
	WebElement state;
	@FindBy(name = "postcode")
	WebElement postcode;
	@FindBy(name = "country_id")
	WebElement country;
	@FindBy(name = "telephone")
	WebElement phoneNumber;
	@FindBy(id = "checkout-loader")
	WebElement loader;
	@FindBy(css = "input[value='flatrate_flatrate']")
	WebElement flatRateRadioButton;
	@FindBy(css = "input[value='tablerate_bestway']")
	WebElement tableRateRadioButton;
	@FindBy(css = ".button.action.continue.primary")
	WebElement nextButton;
	@FindBy(css = ".shipping-address-item.selected-item")
	WebElement address;

	public void enterShipping(String emailAddr, String frstName, String lstName, String addr1, String cityAddr,
			String stateAddr, String postcodeAddr, String countryAddr, String phoneNumberAddr)
			throws InterruptedException {

		waitForElementToDisappear(loader);
		if (address.isDisplayed()) {

		} else {
			firstName.clear();
			firstName.sendKeys(frstName);
			lastName.clear();
			lastName.sendKeys(lstName);
			addLine1.sendKeys(addr1);
			city.sendKeys(cityAddr);
			postcode.sendKeys(postcodeAddr);
			phoneNumber.sendKeys(phoneNumberAddr);

			country.click();
			country.sendKeys(countryAddr);
			state.click();
			state.sendKeys("Washington");
		}

		tableRateRadioButton.click();
		nextButton.click();

	}

}
