package geico.tdd.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;
import geico.tdd.objects.AboutYouPage;
import geico.tdd.objects.GetAHomeQuote;
import geico.tdd.objects.LandingPage;
import geico.tdd.objects.VehicleDetailsPage;
import geico.tdd.utils.Constant;
import geico.tdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import static geico.tdd.utils.IConstant.*;
import java.lang.reflect.Method;
import java.time.Duration;
import static geico.tdd.utils.Constant.*;

public class BaseClass extends ExtentListener {

	protected WebDriver driver;
	protected LandingPage landingPage;
	protected AboutYouPage aboutYouPage;
	protected VehicleDetailsPage vehicleDetailsPage;
	protected GetAHomeQuote getAHomeQuote;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	ReadProperties envVar = new ReadProperties();

	@Parameters({"browser", "env"})
	@BeforeMethod
	public void setUpDriver(String browserName, String env) {
		// Enum example
		// String browserName = envVar.getProperty(getString(browser));
		// String browserName = envVar.getProperty(browser.name());

		// IConstant interface example
		// String browserName = envVar.getProperty(BROWSER);
		String givenUrl = envVar.getProperty(env + "Url");
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperty(IMPLECIT_WAIT);
		// long explicitWait = envVar.getNumProperty(EXPLICIT_WAIT);
		initDriver(browserName);
		initClasses(driver);

		driver.get(givenUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		// wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
	}

	private void initClasses(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		landingPage = new LandingPage(driver);
		aboutYouPage = new AboutYouPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);
		getAHomeQuote = new GetAHomeQuote(driver);

	}

	private void initDriver(String driverName) {
		switch (driverName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, PASSED);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, FAILED);
			test.addScreenCaptureFromPath(captureScreenShot(driver, method.getName()));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, SKIPPED);
		}
	}

	@SuppressWarnings("unused")
	private String getString(Constant constant) {
		return constant.name();
	}

}
