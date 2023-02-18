package geico.tdd.objects;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static geico.tdd.common.CommonActions.*;

import java.time.Duration;



public class LandingPage {
	
	

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@id='section1heading' and text()='The Insurance Savings You Expect']")
	WebElement landingPageTitle;

	@FindBy(xpath = "//div[@class='product-checkbox']//following-sibling::span[@class='icon-vehicle']")
	WebElement carLOB;

	@FindBy(css = ".modal-trigger.btn.btn--primary.btn--full-mobile")
	WebElement startMyQuoteBtn;
	
	@FindBy(xpath = "//h2[contains(text(),\"You're getting an auto quote today!\")]")
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

	public void clickCarLob( WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(carLOB));
		click(carLOB);
	}

	public void clickStartNewQuote(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(startMyQuoteBtn));
		click(startMyQuoteBtn);
	}
	
	public void ValidateAutoQuotePage(String expectedTitle) {
		validate(autoQuotePageTitle, expectedTitle);
	}
		
	
	public void insertZipCodeField(String zip ) {
		
		insert(zipCodeInput, zip);
		 
	}
	
	public void clickHomeOwnerLobBtn() {
		click(homeOwnerLobBtn);
	}
	
	public void clickContinueBtn() {
		click(continueBtn);
	}
	
	

}
