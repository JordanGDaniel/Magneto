package defaultproject.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class womenJacketPage extends AbstractComponents{
	
	WebDriver driver;
	public womenJacketPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".product-item-link")
	List<WebElement> allJackets;
	
	By title = By.cssSelector(".base");
	
	public List<WebElement> getJacketNames() {
		waitForElementToAppear(title);
		return allJackets;
	}
	
	public oliviaPage getProductByName(String jacketName) {
		WebElement oliviaJacket = getJacketNames().stream()
				.filter(product -> product.getText().equals(jacketName)).findFirst().orElse(null);
		oliviaJacket.click();
		oliviaPage oPage = new oliviaPage(driver);
		return oPage;
	}
	
	
}
