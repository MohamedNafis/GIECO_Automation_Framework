package geico.tdd.common;


import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import org.testng.Assert;
import geico.tdd.reporting.Logs;
import net.bytebuddy.asm.Advice.Enter;

public class CommonActions {

	public static void click(WebElement element) {
		element.click();
		Logs.log(element + " ---> has been clicked");
	}

	public static void validate(WebElement element, String expected) {
		String actual = element.getText();
		Logs.log("Validating ---> Actual : ***" + actual + "***. Expected : ***" + expected + "***");
		Assert.assertEquals(actual, expected);
	}
	
	public static void insert( WebElement element, String value) {
		
	
		element.sendKeys(value);
		Logs.log(value + "<--- This value has been passed into ---> " + element);
	}
	
	public static void insert_Enter( WebElement element) {
		
		
		element.sendKeys(Keys.ENTER);
		Logs.log(Keys.ENTER + "<--- This value has been passed into ---> " + element);
	}
	 

}
