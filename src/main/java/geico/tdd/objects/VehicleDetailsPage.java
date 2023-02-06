package geico.tdd.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static geico.tdd.common.CommonActions.*;
public class VehicleDetailsPage {
	
	
	public VehicleDetailsPage( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h4[text()='Vehicle Details']")
	WebElement vehicleDetailsPageTitle;
	
	
	
	public void validateVehicleDetailsPageTitle( String expectedTitle) {
		validate(vehicleDetailsPageTitle, expectedTitle);
	}

}
