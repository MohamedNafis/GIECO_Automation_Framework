package geico.tdd.common;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import geico.tdd.reporting.Logs;

public class CommonActions {

	public static void click(WebElement element) {
		try {
			element.click();
			Logs.log(element + " ---> has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");
			Assert.fail();
		}
	}

	public static void validate(WebElement element, String expected) {
		String actual = "";
		try {
			actual = element.getText();
			Logs.log("Validating ---> Actual : *** " + actual + " ***. Expected : *** " + expected + " ***");
		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");
			Assert.fail();
		}
		Assert.assertEquals(actual, expected);
	}

	public static void insert(WebElement element, String value) {
		try {
			element.sendKeys(value);
			Logs.log(value + " <--- This value has been passed into ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");
			Assert.fail();
		}
	}

	public static void enter(WebElement element) {
		try {
			element.sendKeys(Keys.ENTER);
			Logs.log(Keys.ENTER + "<--- has been Entered ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			Logs.log(element + " ---> Element Not Found");
			Assert.fail();
		}
	}

	public static void dropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		Logs.log(value + "<--- This value has been passed into ---> " + element);

	}

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
