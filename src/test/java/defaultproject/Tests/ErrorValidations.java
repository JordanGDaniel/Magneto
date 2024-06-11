package defaultproject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import defaultproject.PageObjects.customerLoginPage;
import defaultproject.PageObjects.landingPage;
import defaultproject.TestComponents.BaseTest;
import defaultproject.TestComponents.Retry;

public class ErrorValidations extends BaseTest {

	@Test(dataProvider = "getData", groups = {"Error Handling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidation(HashMap<String,String> input) throws IOException{
		landingPage landingPage = launchApplication();
		customerLoginPage CLPage = landingPage.goToCustomerLoginPage();
		CLPage.login(input.get("email"), input.get("pwd"));
		String errorMessage = driver
				.findElement(By.cssSelector(".message-error.error.message"))
				.getText();
		Assert.assertEquals(errorMessage,
				"The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\defaultproject\\Data\\TestDataSet1.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };

	}

}
