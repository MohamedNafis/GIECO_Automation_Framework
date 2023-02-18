package geico.tdd.test.home;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import geico.tdd.base.BaseClass;
import geico.tdd.reporting.Logs;
import geico.tdd.utils.HomeData;

public class HomeQuoteTest extends BaseClass {

	@Parameters({ "zipCode2", "getAHQPageTitle", "location", "unitNumber" })
	@Test(enabled = true, priority = 1, groups = "home")
	public void createAHomeQuoteTest(String zipCode2, String getAHQPageTitle, String location, String unitNumber) {

		HomeData homeData = new HomeData(zipCode2, getAHQPageTitle, location, unitNumber);

		getAHomeQuote.clickHomeLob(driver);
		getAHomeQuote.insertZipCode2(homeData.getZipCode2());
		getAHomeQuote.clickStartNewQuote(driver);
		getAHomeQuote.validateGetAHomeQuotePageTitle(homeData.getGetAHQPageTitle());
		getAHomeQuote.insertLocation(homeData.getLocation());
		getAHomeQuote.insertUnitNumber(homeData.getUnitNumber());
		getAHomeQuote.clickNextBtn();
	}

	@Test(enabled = false, priority = 3, groups = { "home",
			"non-func" }, dependsOnMethods = "createAHomeQuoteTest", ignoreMissingDependencies = true)
	public void test1() {
		Logs.log("test1");
	}

	@Test(enabled = false, priority = 4, groups = { "home", "non-func" }, invocationCount = 2)
	public void test2() {
		Logs.log("test2");
		Assert.fail();
	}

	@Test(enabled = false, priority = 5, groups = { "home",
			"non-func" }, retryAnalyzer = geico.tdd.retry.RetryFailedTests.class)
	public void testRetry() {
		Logs.log("Retry Test");
		Assert.fail();
	}

}
