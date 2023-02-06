package geico.tdd.objects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





import static geico.tdd.common.CommonActions.*;



public class LandingPage {
	
	

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'The Insurance Savings You Expect')]")
	WebElement landingPageTitle;

	@FindBy(xpath = "//div[@class='product-checkbox']//following-sibling::span[@class='icon-vehicle']")
	WebElement carLOB;

	@FindBy(css = ".modal-trigger.btn.btn--primary.btn--full-mobile")
	WebElement startMyQuoteBtn;
	
	@FindBy(xpath = "(//h2[@class='modal-headline'])[1]")
	WebElement autoQuotePageTitle;
	
	@FindBy(css = "#bundle-modal-zip")
	WebElement zipCodeInput;
	
	@FindBy(xpath = "(//span[@class='icon-homeowner-ins'])[2]")
	WebElement homeOwnerLobBtn;
	
	@FindBy(xpath = "//input[@class='btn btn--primary btn--full-mobile']")
	WebElement continueBtn;

	
	public void validateLandingPageTitle(String expectedTitle) {
		validate(landingPageTitle, expectedTitle);
	}

	public void clickCarLob() {
		click(carLOB);
	}

	public void clickStartNewQuote() {
		click(startMyQuoteBtn);
	}
	
	public void ValidateAutoQuotePage(String expectedTitle) {
		validate(autoQuotePageTitle, expectedTitle);
	}
		
	
	public void insertZipCodeField( ) {
		
		insert(zipCodeInput, "10467");
		 
	}
	
	public void clickHomeOwnerLobBtn() {
		click(homeOwnerLobBtn);
	}
	
	public void clickContinueBtn() {
		click(continueBtn);
	}
	
	

}
