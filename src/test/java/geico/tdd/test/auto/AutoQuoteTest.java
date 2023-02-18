package geico.tdd.test.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import geico.tdd.base.BaseClass;
import geico.tdd.utils.AutoData;

public class AutoQuoteTest extends BaseClass {

	@Parameters({ "zipCode", "expectedAbtPageTitle", "dateOfBirth", "firstName", "lastName", "address", "aptNo",
			"expectedVhdPageTitle", "vhcYear", "vhcMake", "vhcModel" })
	@Test(enabled = true, priority = 1, groups = "auto")
	public void createAQuoteTes(String zipCode, String expectedAbtPageTitle, String dateOfBirth, String firstName,
			String lastName, String address, String aptNo, String expectedVhdPageTitle, String vhcYear, String vhcMake,
			String vhcModel) {
		AutoData autoData = new AutoData(zipCode, expectedAbtPageTitle, dateOfBirth, firstName, lastName, address,
				aptNo, expectedVhdPageTitle, vhcYear, vhcMake, vhcModel);

		// landingPage.validateLandingPageTitle("The Insurance Savings You Expect");
		landingPage.clickCarLob(driver);
		landingPage.clickStartNewQuote(driver);
		// landingPage.ValidateAutoQuotePage("You're getting an auto quote today!");
		landingPage.insertZipCodeField(autoData.getZipCode());
		landingPage.clickContinueBtn();
		aboutYouPage.ValidateAboutYouPageTitle(autoData.getExpectedAbtPageTitle());
		aboutYouPage.insertDateOfBirthField(autoData.getDateOfBirth());
		aboutYouPage.clickNextBtn1();
		aboutYouPage.clickNextBtn2();
		aboutYouPage.insertFirstNameField(autoData.getFirstName());
		aboutYouPage.insertLastNameField(autoData.getLastName());
		aboutYouPage.clickNextBtn1();
		aboutYouPage.clickNextBtn2();
		aboutYouPage.insertAddressField(autoData.getAddress());
		aboutYouPage.insertAptField(autoData.getAptNo());
		aboutYouPage.clickNextBtn3();
		vehicleDetailsPage.validateVehicleDetailsPageTitle(autoData.getExpectedVhdPageTitle());
		vehicleDetailsPage.clickAlertCloseBtn();
		vehicleDetailsPage.clickVehicleYearSelect(autoData.getVhcYear());
		vehicleDetailsPage.clickVehicleMakeSelect(autoData.getVhcMake());
		vehicleDetailsPage.clickVehicleModelSelect(autoData.getVhcModel());
	}

}
