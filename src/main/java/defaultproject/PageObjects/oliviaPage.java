package defaultproject.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import defaultproject.AbstractComponents.AbstractComponents;

public class oliviaPage extends AbstractComponents{
	
	WebDriver driver;
	public oliviaPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "page-title-wrapper")
	WebElement womenJacketLink;
	
	//option-label-size-143-item-166
	By size28 = By.id("option-label-size-143-item-166");
	
	By colourBlue = By.id("option-label-color-93-item-50");
	
	By addToCart = By.id("product-addtocart-button");
	
	By title = By.cssSelector(".base");
	
	public String selectColourAndSize() {
		waitForElementToAppear(title);
		driver.findElement(size28).click();
		driver.findElement(colourBlue).click();
		driver.findElement(addToCart).click();
		waitForTextToAppear(addToCart, "Added");
		String buttonText = driver.findElement(addToCart).getText();
		return buttonText;
	}

}
