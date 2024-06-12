package defaultproject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import defaultproject.PageObjects.customerLoginPage;
import defaultproject.PageObjects.landingPage;
import defaultproject.PageObjects.oliviaPage;
import defaultproject.PageObjects.womenJacketPage;
import defaultproject.TestComponents.Retry;
import defaultproject.TestComponents.BaseTest;

public class TestScenario1 extends BaseTest{
	
	@Test(dataProvider = "getData", groups = {"Regression"}) //, retryAnalyzer=Retry.class
	public void threeItemsToBuy(HashMap<String,String> input) throws IOException, InterruptedException {
		landingPage landingPage = launchApplication();
		customerLoginPage CLPage = landingPage.goToCustomerLoginPage();
		CLPage.login(input.get("email"), input.get("pwd"));
		womenJacketPage wJPage = CLPage.goToWomenJacketPage(input.get("userName"));
		oliviaPage oPage = wJPage.getProductByName(input.get("jacketName"));
		String addedText = oPage.selectColourAndSize();
		Assert.assertEquals(addedText, "Added");
	}
	

	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\defaultproject\\Data\\TestDataSet3.json");
		return new Object[][] { {data.get(0)} };

	}
}
