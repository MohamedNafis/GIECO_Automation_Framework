package geico.tdd.objects;

import static geico.tdd.common.CommonActions.*;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AboutYouPage{
	
	
	

	public AboutYouPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".title.active")
	WebElement aboutYouPageTitle;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dateOfBirthInput;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextBtn1;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/input[1]")
	WebElement firstNameInput;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/main[1]/div[2]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/input[1]")
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
	
	public void insertDateOfBirthField() {
		insert(dateOfBirthInput, "10/10/1990");
	}

	public void clickNextBtn1() {
		click(nextBtn1);
	}

	public void insertFirstNameField( ) {
		
		insert(firstNameInput, "JON");

	}
	
	public void insertLastNameField() {
		insert(lastNmaeInput, "son");
	}
	

	public void clickNextBtn2() {
		click(nextBtn2);
	}
	
	public void insertAddressField() {
		
		insert(addressInput, "3105 Decatur Ave");
		insert_Enter(aboutYouPageTitle);
	}
	
	
	public void insertAptField() {
		insert(aptInput, "34B");
	}
	
	public void clickNextBtn3() {
		click(nextBtn3);
	}

}
