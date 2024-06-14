package defaultproject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import defaultproject.PageObjects.bagsPage;
import defaultproject.PageObjects.shippingPage;
import defaultproject.PageObjects.customerLoginPage;
import defaultproject.PageObjects.fitnessEquipmentPage;
import defaultproject.PageObjects.gearPage;
import defaultproject.PageObjects.womenJacketPage;
import defaultproject.PageObjects.landingPage;
import defaultproject.PageObjects.menBottomPage;
import defaultproject.PageObjects.menHoodiePage;
import defaultproject.PageObjects.menJacketPage;
import defaultproject.PageObjects.menPage;
import defaultproject.PageObjects.menPantsPage;
import defaultproject.PageObjects.menShortsPage;
import defaultproject.PageObjects.menTankPage;
import defaultproject.PageObjects.menTeesPage;
import defaultproject.PageObjects.menTopsPage;
import defaultproject.PageObjects.myAccountPage;
import defaultproject.PageObjects.myWishListPage;
import defaultproject.PageObjects.salePage;
import defaultproject.PageObjects.trainingPage;
import defaultproject.PageObjects.videoDownloadPage;
import defaultproject.PageObjects.watchesPage;
import defaultproject.PageObjects.whatsNewPage;
import defaultproject.PageObjects.womenBottomPage;
import defaultproject.PageObjects.womenBrasPage;
import defaultproject.PageObjects.womenHoodiePage;
import defaultproject.PageObjects.womenPage;
import defaultproject.PageObjects.womenPantsPage;
import defaultproject.PageObjects.womenShortsPage;
import defaultproject.PageObjects.womenTeesPage;
import defaultproject.PageObjects.womenTopsPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By addToCart = By.id("product-addtocart-button");
	
	By title = By.cssSelector(".base");

	@FindBy(css = "#ui-id-3")
	WebElement whatsNewButton;
	
	public whatsNewPage goToWhatsNewPage() {
		whatsNewButton.click();
		whatsNewPage wNPage = new whatsNewPage(driver);
		return wNPage;
	}

	@FindBy(css = "#ui-id-4")
	WebElement womenButton;
	
	public womenPage goToWomenPage() {
		womenButton.click();
		womenPage wPage = new womenPage(driver);
		return wPage;
	}

	@FindBy(css = "#ui-id-9")
	WebElement womenTopsLink;
	
	public womenTopsPage goToWomenTopsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenTopsLink).click().build().perform();

		womenTopsPage wtPage = new womenTopsPage(driver);
		return wtPage;
	}

	@FindBy(css = "#ui-id-11")
	WebElement womenJacketLink;
	
	public womenJacketPage goToWomenJacketPage(String userName) {
		waitForTextToAppear(welcomeBy, "Welcome, "+userName+"!");
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenTopsLink).moveToElement(womenJacketLink).click().build()
				.perform();

		womenJacketPage wJPage = new womenJacketPage(driver);
		return wJPage;
	}
	
	@FindBy(id = "ui-id-12")
	WebElement womenHoodieLink;
	
	public womenHoodiePage goToWomenHoodiePage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenTopsLink).moveToElement(womenHoodieLink).click().build()
				.perform();

		womenHoodiePage wHPage = new womenHoodiePage(driver);
		return wHPage;
	}
	
	@FindBy(id = "ui-id-13")
	WebElement womenTeesLink;
	
	public womenTeesPage goToWomenTeesPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenTopsLink).moveToElement(womenTeesLink).click().build()
				.perform();

		womenTeesPage wTeePage = new womenTeesPage(driver);
		return wTeePage;
	}
	
	@FindBy(id = "ui-id-14")
	WebElement womenBrasLink;
	
	public womenBrasPage goToWomenBrasPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenTopsLink).moveToElement(womenBrasLink).click().build()
				.perform();

		womenBrasPage wBraPage = new womenBrasPage(driver);
		return wBraPage;
	}
	
	@FindBy(id = "ui-id-10")
	WebElement womenBottomLink;
	
	public womenBottomPage goToWomenBottomPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenBottomLink).click().build().perform();

		womenBottomPage wBPage = new womenBottomPage(driver);
		return wBPage;
	}
	
	@FindBy(id = "ui-id-15")
	WebElement womenPantsLink;
	
	public womenPantsPage goToWomenPantsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenBottomLink).moveToElement(womenPantsLink).click().build()
		.perform();

		womenPantsPage wPPage = new womenPantsPage(driver);
		return wPPage;
	}
	
	@FindBy(id = "ui-id-16")
	WebElement womenShortsLink;
	
	public womenShortsPage goToWomenShortsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(womenButton).moveToElement(womenBottomLink).moveToElement(womenShortsLink).click().build()
		.perform();

		womenShortsPage wSPage = new womenShortsPage(driver);
		return wSPage;
	}
	
	@FindBy(css = "#ui-id-5")
	WebElement menButton;
	
	public menPage goToMenPage() {
		menButton.click();
		menPage mPage = new menPage(driver);
		return mPage;
	}

	@FindBy(id = "ui-id-17")
	WebElement menTopsLink;
	
	public menTopsPage goToMenTopsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menTopsLink).click().build().perform();

		menTopsPage mtPage = new menTopsPage(driver);
		return mtPage;
	}
	
	@FindBy(id = "ui-id-19")
	WebElement menJacketLink;
	
	public menJacketPage goToMenJacketPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menTopsLink).moveToElement(menJacketLink).click().build()
				.perform();

		menJacketPage mJPage = new menJacketPage(driver);
		return mJPage;
	}
	
	@FindBy(id = "ui-id-20")
	WebElement menHoodieLink;
	
	public menHoodiePage goToMenHoodiePage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menTopsLink).moveToElement(menHoodieLink).click().build()
				.perform();

		menHoodiePage mHPage = new menHoodiePage(driver);
		return mHPage;
	}
	
	@FindBy(id = "ui-id-21")
	WebElement menTeesLink;
	
	public menTeesPage goToMenTeesPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menTopsLink).moveToElement(menTeesLink).click().build()
				.perform();

		menTeesPage mTeePage = new menTeesPage(driver);
		return mTeePage;
	}
	
	@FindBy(id = "ui-id-22")
	WebElement menTanksLink;
	
	public menTankPage goToMenTankPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menTopsLink).moveToElement(menTanksLink).click().build()
				.perform();

		menTankPage mTankPage = new menTankPage(driver);
		return mTankPage;
	}
	
	@FindBy(id = "ui-id-18")
	WebElement menBottomLink;
	
	public menBottomPage goToMenBottomPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menBottomLink).click().build().perform();

		menBottomPage mBPage = new menBottomPage(driver);
		return mBPage;
	}
	
	@FindBy(id = "ui-id-23")
	WebElement menPantsLink;
	
	public menPantsPage goToMenPantsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menBottomLink).moveToElement(menPantsLink).click().build()
		.perform();

		menPantsPage mPPage = new menPantsPage(driver);
		return mPPage;
	}
	
	@FindBy(id = "ui-id-24")
	WebElement menShortsLink;
	
	public menShortsPage goToMenShortsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(menButton).moveToElement(menBottomLink).moveToElement(menShortsLink).click().build()
		.perform();

		menShortsPage mSPage = new menShortsPage(driver);
		return mSPage;
	}
	
	@FindBy(css = "#ui-id-6")
	WebElement gearButton;
	
	public gearPage goToGearPage() {
		gearButton.click();
		gearPage gPage = new gearPage(driver);
		return gPage;
	}
	
	@FindBy(css = "#ui-id-25")
	WebElement bagsLink;
	
	public bagsPage goToBagsPage() {
		Actions a = new Actions(driver);
		a.moveToElement(gearButton).moveToElement(bagsLink).click().build().perform();

		bagsPage bPage = new bagsPage(driver);
		return bPage;
	}
	
	@FindBy(css = "#ui-id-26")
	WebElement fitnessEquipmentLink;
	
	public fitnessEquipmentPage goToFitnessEquipmentPage() {
		Actions a = new Actions(driver);
		a.moveToElement(gearButton).moveToElement(fitnessEquipmentLink).click().build().perform();

		fitnessEquipmentPage fEPage = new fitnessEquipmentPage(driver);
		return fEPage;
	}
	
	@FindBy(css = "#ui-id-27")
	WebElement watchesLink;
	
	public watchesPage goToWatchesPage() {
		Actions a = new Actions(driver);
		a.moveToElement(gearButton).moveToElement(watchesLink).click().build().perform();

		watchesPage watchPage = new watchesPage(driver);
		return watchPage;
	}

	@FindBy(css = "#ui-id-7")
	WebElement trainingButton;
	
	public trainingPage goToTrainingPage() {
		trainingButton.click();
		trainingPage tPage = new trainingPage(driver);
		return tPage;
	}
	
	@FindBy(css = "#ui-id-28")
	WebElement videoDownloadLink;
	
	public videoDownloadPage goToVideoDownloadPage() {
		Actions a = new Actions(driver);
		a.moveToElement(trainingButton).moveToElement(videoDownloadLink).click().build().perform();

		videoDownloadPage vDPage = new videoDownloadPage(driver);
		return vDPage;
	}
	
	@FindBy(css = "#ui-id-8")
	WebElement saleButton;
	
	public salePage goTosalePage() {
		saleButton.click();
		salePage sPage = new salePage(driver);
		return sPage;
	}
	

	@FindBy(css = "#top-cart-btn-checkout")
	WebElement checkoutButton;
	
	@FindBy(css = ".action.showcart")
	WebElement cartButton;
	
	public shippingPage goToCheckoutPage() {
		cartButton.click();
		checkoutButton.click();
		shippingPage cOPage = new shippingPage(driver);
		return cOPage;
	}
	
	@FindBy(css = "div[class='panel header'] button[type='button']")
	WebElement welcomeButton;

	@FindBy(css = "div[class='panel wrapper'] li:nth-child(1) a:nth-child(1)")
	WebElement myAccountButton;

	@FindBy(css = "div[aria-hidden='false'] li[class='link wishlist'] a")
	WebElement myWishListButton;

	@FindBy(css = "div[aria-hidden='false'] li[data-label='or'] a")
	WebElement signOutButton;

	@FindBy(css = ".authorization-link")
	WebElement signInButton;

	By welcomeBy = By.cssSelector("div[class='panel header'] span[class='logged-in']");

	By signInBy = By.cssSelector(".authorization-link");

	public void waitForElementToAppear(By findBy) {
		WebDriverWait waitAppear = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitAppear.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait waitDisappear = new WebDriverWait(driver, Duration.ofSeconds(5));
		waitDisappear.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void waitForTextToAppear(By ele, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(ele, text));
	}
	
	public void waitForTwoWindows(int windowCount) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfWindowsToBe(windowCount));
	}

	public customerLoginPage goToCustomerLoginPage() {
		signInButton.click();
		customerLoginPage cLPage = new customerLoginPage(driver);
		return cLPage;
	}

	public myAccountPage goToMyAccountPage(String userName) {
		waitForTextToAppear(welcomeBy, "Welcome, "+userName+"!");
		welcomeButton.click();
		myAccountButton.click();
		myAccountPage MAPage = new myAccountPage(driver);
		return MAPage;
	}

	public myWishListPage goToMyWishListPage(String userName) {
		waitForTextToAppear(welcomeBy, "Welcome, "+userName+"!");
		welcomeButton.click();
		myWishListButton.click();
		myWishListPage mWLPage = new myWishListPage(driver);
		return mWLPage;
	}

	public landingPage signOut(String userName) {
		waitForTextToAppear(welcomeBy, "Welcome, "+userName+"!");
		welcomeButton.click();
		signOutButton.click();
		waitForElementToAppear(signInBy);
		landingPage lPage = new landingPage(driver);
		return lPage;
	}

}
