package Generic_Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POM_Repo.LoginPage;

public class BaseClass {

	public WebDriver driver;;

	@BeforeClass
	public void BC() throws Throwable {
		CommonDataFile commonData = new CommonDataFile();
		String BROWSER = commonData.getPropertiesData("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		System.out.println("launch browser");
	}

	@BeforeMethod
	public void BM() throws Throwable {

		CommonDataFile commonData = new CommonDataFile();
		String URL = commonData.getPropertiesData("url");
		String USERNAME = commonData.getPropertiesData("username");
		String PASSWORD = commonData.getPropertiesData("password");

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.logintoApp(USERNAME, PASSWORD);
		System.out.println("login into Application");
	}

	@AfterMethod

	public void AM() throws Throwable {
		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.moveToElements(driver, AmdLink);

		driver.findElement(By.linkText("Sign Out")).click();

		System.out.println("logout from Application");
	}

	@AfterClass
	public void AC() {
		driver.quit();
		System.out.println("CLose Browser");
	}
}
