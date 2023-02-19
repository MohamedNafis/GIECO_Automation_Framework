package geico.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static geico.tdd.common.CommonActions.*;
import java.time.Duration;

public class GetAHomeQuote {

	public GetAHomeQuote(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='product-checkbox'])[2]")
	WebElement homeLOB;

	@FindBy(xpath = "//input[@class='zip-code-input' and @id='zip']")
	WebElement zipCodeInput2;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[5]/button[1]")
	WebElement startMyQuoteBtn;

	@FindBy(xpath = "//h1[@class='breakdownQuestionHeader']")
	WebElement getAHomeQuotePageTitle;

	@FindBy(css = ".address-search-field.pac-target-input.address_1")
	WebElement enterLocation;
	@FindBy(className = "f_Apt")
	WebElement unitNumberInput;

	@FindBy(css = ".btn.btn--primary.btn--full-mobile.wizardNavigation.wizardForwardsNavigation")
	WebElement nextBtn;

	public void clickHomeLob(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(homeLOB));
		click(homeLOB);
	}

	public void insertZipCode2(String zip) {

		insert(zipCodeInput2, zip);

	}

	public void clickStartNewQuote(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(startMyQuoteBtn));
		click(startMyQuoteBtn);

	}

	public void validateGetAHomeQuotePageTitle(String expectedTitle) {
		validate(getAHomeQuotePageTitle, expectedTitle);
	}

	public void insertLocation(String location) {
		insert(enterLocation, location);
		enter(enterLocation);
	}

	public void insertUnitNumber(String unitNumber) {
		insert(unitNumberInput, unitNumber);
	}

	public void clickNextBtn() {
		click(nextBtn);
	}

}
