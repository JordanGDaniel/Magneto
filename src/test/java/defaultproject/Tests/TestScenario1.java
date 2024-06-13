package defaultproject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import defaultproject.PageObjects.checkoutPage;
import defaultproject.PageObjects.customerLoginPage;
import defaultproject.PageObjects.eosPage;
import defaultproject.PageObjects.idaPage;
import defaultproject.PageObjects.landingPage;
import defaultproject.PageObjects.oliviaPage;
import defaultproject.PageObjects.womenHoodiePage;
import defaultproject.PageObjects.womenJacketPage;
import defaultproject.PageObjects.womenPantsPage;
import defaultproject.TestComponents.Retry;
import defaultproject.TestComponents.BaseTest;

public class TestScenario1 extends BaseTest{
	
	@Test(dataProvider = "getData", groups = {"Regression"}) //, retryAnalyzer=Retry.class
	public void threeItemsToBuy(HashMap<String,String> input) throws IOException, InterruptedException {
		landingPage landingPage = launchApplication();
		customerLoginPage CLPage = landingPage.goToCustomerLoginPage();
		CLPage.login(input.get("email"), input.get("pwd"));
		CLPage.isBasketEmpty();
		womenJacketPage wJPage = CLPage.goToWomenJacketPage(input.get("userName"));
		oliviaPage oPage = wJPage.getProductByName(input.get("jacketName"));
		String addedText = oPage.selectColourAndSize();
		Assert.assertEquals(addedText, "Added");
		womenHoodiePage wHPage = oPage.goToWomenHoodiePage();
		eosPage eoPage = wHPage.getHoodieByName(input.get("hoodieName"));
		String eosAddedText = eoPage.eosSelectColourAndSize();
		Assert.assertEquals(eosAddedText, "Added");
		womenPantsPage wPPage = eoPage.goToWomenPantsPage();
		idaPage iPage = wPPage.getPantsByName(input.get("pantsName"));
		String idaAddedText = iPage.idaSelectColourAndSize();
		Assert.assertEquals(idaAddedText, "Added");
		checkoutPage cOPage = iPage.goToCheckoutPage();
		cOPage.enterShipping(input.get("email"), input.get("firstName"), input.get("lastName"), input.get("addr1"), input.get("city"), 
				input.get("state"), input.get("postcode"), input.get("country"), input.get("phoneNumber"));
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\defaultproject\\Data\\TestDataSet3.json");
		return new Object[][] { {data.get(0)} };

	}
}
