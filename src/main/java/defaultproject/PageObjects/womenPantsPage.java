package defaultproject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class womenPantsPage extends AbstractComponents{
	
	WebDriver driver;
	public womenPantsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".product-item-link")
	List<WebElement> allPants;
	
	By title = By.cssSelector(".base");
	
	public List<WebElement> getPantsNames() {
		waitForElementToAppear(title);
		return allPants;
	}
	
	public idaPage getPantsByName(String pantsName) {
		WebElement eosHoodie = getPantsNames().stream()
				.filter(product -> product.getText().equals(pantsName)).findFirst().orElse(null);
		eosHoodie.click();
		idaPage idaPage = new idaPage(driver);
		return idaPage;
	}

}
