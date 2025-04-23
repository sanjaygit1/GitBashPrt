package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.CommonDataFile;
import Generic_Utilities.Webdriver_Utility;

public class StaleElementReferenceExcep {

	public static void main(String[] args) throws Throwable {
		
		CommonDataFile commonData = new CommonDataFile();
		String BROWSER = commonData.getPropertiesData("browser");
		String URL = commonData.getPropertiesData("url");
		String USERNAME = commonData.getPropertiesData("username");
		String PASSWORD = commonData.getPropertiesData("password");

		WebDriver driver;
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

		Webdriver_Utility wlib = new Webdriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitElementsToLoad(driver);

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		WebElement login = driver.findElement(By.id("submitButton"));
		driver.navigate().refresh();
	    login.click();
		
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		WebElement login1 = driver.findElement(By.id("submitButton"));
		login1.click();

	}

}
