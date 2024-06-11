package defaultproject.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class landingPage extends AbstractComponents{
	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		super(driver); //super send to parent
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToLandingPage() {
		driver.get("https://magento.softwaretestingboard.com/");
	}
}
