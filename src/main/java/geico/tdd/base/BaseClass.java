package geico.tdd.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import geico.tdd.objects.AboutYouPage;
import geico.tdd.objects.LandingPage;
import geico.tdd.objects.VehicleDetailsPage;
import geico.tdd.utils.Constant;
import geico.tdd.utils.ReadProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

import static geico.tdd.utils.IConstant.*;

import java.time.Duration;

import static geico.tdd.utils.Constant.*;

public class BaseClass {

	protected WebDriver driver;
	protected LandingPage landingPage;
	protected AboutYouPage aboutYouPage;
	protected VehicleDetailsPage vehicleDetailsPage;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	ReadProperties envVar;

	@BeforeSuite
	public void setUpSuite() {
		envVar = new ReadProperties();
	}

	@BeforeMethod
	public void setUpDriver() {
		// Enum example
		String browserName = envVar.getProperty(getString(browser));
		// String browserName = envVar.getProperty(browser.name());

		// IConstant interface example
		// String browserName = envVar.getProperty(BROWSER);
		String url = envVar.getProperty(URL);
		long pageLoadWait = envVar.getNumProperty(PAGELOAD_WAIT);
		long implicitWait = envVar.getNumProperty(IMPLECIT_WAIT);
		long explicitWait = envVar.getNumProperty(EXPLICIT_WAIT);
		initDriver(browserName);
		initClasses(driver);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
	}

	private void initClasses(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		landingPage = new LandingPage(driver);
		aboutYouPage = new AboutYouPage(driver);
		vehicleDetailsPage = new VehicleDetailsPage(driver);

	}

	private void initDriver(String driverName) {
		switch (driverName) {
		//case CHROME:
			//WebDriverManager.chromedriver().setup();
		//	driver = new ChromeDriver();
		//	break;
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

	private String getString(Constant constant) {
		return constant.name();
	}

}
