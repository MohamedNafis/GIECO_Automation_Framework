package geico.tdd.objects;

import static geico.tdd.common.CommonActions.*;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AboutYouPage{
	
	
	WebDriver driver;

	public AboutYouPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".title.active")
	WebElement aboutYouPageTitle;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dateOfBirthInput;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextBtn1;
	@FindBy(xpath = "(//input[@size='21'])[1]")
	WebElement firstNameInput;
	@FindBy(xpath = "(//input[@size='21'])[2]")
	WebElement lastNmaeInput;
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement nextBtn2;
	@FindBy(xpath = "//input[@name='autocomplete'][1]")
	WebElement addressInput;
	@FindBy(xpath = "//input[@data-formotivid='UnitNumber']")
	WebElement aptInput;
	@FindBy(css = "button.btn.btn--primary.btn--full-mobile.btn--pull-right")
	WebElement nextBtn3;
	
	
	
	

	public void ValidateAboutYouPageTitle(String expectedTitle) {
		validate(aboutYouPageTitle, expectedTitle);
	}
	
	public void insertDateOfBirthField( String dateOfBirth) {
		insert(dateOfBirthInput, dateOfBirth);
	}

	public void clickNextBtn1() {
		click(nextBtn1);
	}

	public void insertFirstNameField(String firstName ) {
		
		insert(firstNameInput, firstName);

	}
	
	public void insertLastNameField(String lastName) {
		insert(lastNmaeInput, lastName);
	}
	

	public void clickNextBtn2() {
		click(nextBtn2);
	}
	
	public void insertAddressField(String address) {
		
		insert(addressInput, address);
		enter(aboutYouPageTitle);
	}
	
	
	public void insertAptField(String apt) {
		insert(aptInput, apt);
	}
	
	public void clickNextBtn3() {
		click(nextBtn3);
	}
	 
	

}
