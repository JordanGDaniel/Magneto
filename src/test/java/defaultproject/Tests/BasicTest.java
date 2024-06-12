package defaultproject.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import defaultproject.PageObjects.bagsPage;
import defaultproject.PageObjects.customerLoginPage;
import defaultproject.PageObjects.fitnessEquipmentPage;
import defaultproject.PageObjects.gearPage;
import defaultproject.PageObjects.womenJacketPage;
import defaultproject.PageObjects.womenPage;
import defaultproject.PageObjects.womenPantsPage;
import defaultproject.PageObjects.womenShortsPage;
import defaultproject.PageObjects.womenTeesPage;
import defaultproject.PageObjects.womenTopsPage;
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
import defaultproject.TestComponents.BaseTest;
import defaultproject.TestComponents.Retry;

public class BasicTest extends BaseTest {

	@Test(dataProvider = "getData", groups = {"Error Handling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidation(HashMap<String,String> input) throws IOException, InterruptedException{
		landingPage landingPage = launchApplication();
		customerLoginPage CLPage = landingPage.goToCustomerLoginPage();
		CLPage.login(input.get("email"), input.get("pwd"));
		myAccountPage mAPage = CLPage.goToMyAccountPage(input.get("userName"));
		myWishListPage mWLPage = mAPage.goToMyWishListPage(input.get("userName"));
		whatsNewPage wNPage = mWLPage.goToWhatsNewPage();
		womenPage wPage = wNPage.goToWomenPage();
		womenTopsPage wTPage = wPage.goToWomenTopsPage();
		womenJacketPage wJPage = wTPage.goToWomenJacketPage(input.get("userName"));
		womenHoodiePage wHPage = wJPage.goToWomenHoodiePage();
		womenTeesPage wTeePage = wHPage.goToWomenTeesPage();
		womenBrasPage wBraPage = wTeePage.goToWomenBrasPage();
		womenBottomPage wBottomPage = wBraPage.goToWomenBottomPage();
		womenPantsPage wPantsPage = wBottomPage.goToWomenPantsPage();
		womenShortsPage wShortsPage = wPantsPage.goToWomenShortsPage();
		menPage mPage = wShortsPage.goToMenPage();
		menTopsPage mTPage = mPage.goToMenTopsPage();
		menJacketPage mJPage = mTPage.goToMenJacketPage();
		menHoodiePage mHPage = mJPage.goToMenHoodiePage();
		menTeesPage mTeePage = mHPage.goToMenTeesPage();
		menTankPage mTankPage = mTeePage.goToMenTankPage();
		menBottomPage mBottomPage = mTankPage.goToMenBottomPage();
		menPantsPage mPantsPage = mBottomPage.goToMenPantsPage();
		menShortsPage mShortsPage = mPantsPage.goToMenShortsPage();
		gearPage gPage = mShortsPage.goToGearPage();
		bagsPage bagsPage = gPage.goToBagsPage();
		fitnessEquipmentPage fEPage = bagsPage.goToFitnessEquipmentPage();
		watchesPage watchPage = fEPage.goToWatchesPage();
		trainingPage tPage = gPage.goToTrainingPage();
		videoDownloadPage vDPage = tPage.goToVideoDownloadPage();
		salePage sPage = tPage.goTosalePage();
		landingPage lPage = sPage.signOut(input.get("userName"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+ "\\src\\test\\java\\defaultproject\\Data\\TestDataSet2.json");
		return new Object[][] { {data.get(0)} };

	}

}
