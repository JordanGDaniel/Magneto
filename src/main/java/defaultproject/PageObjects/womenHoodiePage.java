package defaultproject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class womenHoodiePage extends AbstractComponents{
	
	WebDriver driver;
	public womenHoodiePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".product-item-link")
	List<WebElement> allHoodies;
	
	By title = By.cssSelector(".base");
	
	public List<WebElement> getHoodieNames() {
		waitForElementToAppear(title);
		return allHoodies;
	}
	
	public eosPage getHoodieByName(String hoodieName) {
		WebElement eosHoodie = getHoodieNames().stream()
				.filter(product -> product.getText().equals(hoodieName)).findFirst().orElse(null);
		eosHoodie.click();
		eosPage eosPage = new eosPage(driver);
		return eosPage;
	}
}
