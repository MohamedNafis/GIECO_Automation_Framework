package geico.tdd.test.auto;


import org.testng.annotations.Test;

import geico.tdd.base.BaseClass;


public class AutoQuoteTest extends BaseClass {
	
	@Test(enabled = true)
	public void createAQuoteTes()  {
		//landingPage.validateLandingPageTitle("The Insurance Savings You Expect");
		landingPage.clickCarLob();
		landingPage.clickStartNewQuote();
		//getAQuotePage.ValidateAutoQuotePage("You're getting an auto quote today!");
		landingPage.insertZipCodeField();
		//getAQuotePage.clickHomeOwnerLobBtn();
		landingPage.clickContinueBtn();
		aboutYouPage.ValidateAboutYouPageTitle("About You");
		aboutYouPage.insertDateOfBirthField();
		aboutYouPage.clickNextBtn1();
		aboutYouPage.clickNextBtn2();
		aboutYouPage.insertFirstNameField();
		aboutYouPage.insertLastNameField() ;
		aboutYouPage.clickNextBtn1();
		aboutYouPage.clickNextBtn2();
		aboutYouPage.insertAddressField();
		aboutYouPage.insertAptField();
		aboutYouPage.clickNextBtn3();
		vehicleDetailsPage.validateVehicleDetailsPageTitle("Vehicle Details");
		
	}
	
	
	
	
	

}
