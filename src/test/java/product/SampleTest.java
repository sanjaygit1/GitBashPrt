package product;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.CommonDataFile;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Webdriver_Utility;
import POM_Repo.LoginPage;
import POM_Repo.LoginPage1;

@Test
public class SampleTest extends BaseClass {

	public void SampleTest( ) throws Throwable {
		
		CommonDataFile commonData = new CommonDataFile();
//		String BROWSER = commonData.getPropertiesData("browser");
		String URL = commonData.getPropertiesData("url");
		String USERNAME = commonData.getPropertiesData("username");
		String PASSWORD = commonData.getPropertiesData("password");

//		WebDriver driver;
//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}
//
//		else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//
//		else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new EdgeDriver();
//		}

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();

		//getter method
//		LoginPage login = new LoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPassWordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		//using pagefactory.initElement()
//		LoginPage login = new LoginPage(driver);
//		login.logintoApp(driver, USERNAME, PASSWORD);

		//		driver.navigate().refresh();
//		login.getLoginButton().click();
		
		//without pageFactory.initElement()
		LoginPage1 login = new LoginPage1(driver);
		login.login(USERNAME, PASSWORD);
		
		
//		login.logintoApp(driver, USERNAME, PASSWORD);
//		login.getLoginButton().click();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.getExcelData("Sheet1", 0, 0) + ranNum;

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();

		String campName = elib.getExcelData("Sheet1", 2, 0);
		driver.findElement(By.name("campaignname")).sendKeys(campName);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

	/*	Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String Url = driver.getCurrentUrl();
			System.out.println(Url);
			if (Url.contains("Products&action"))

			{
				break;
			}
		}

		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.name("search")).click();*/
	}

}
