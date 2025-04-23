package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromPropertiesFile {

	public static void main(String[] args) throws Throwable {

		// step1:-setting up the physical file path
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData2pm.properties");

		// step2:-load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- read the keys using getProperty()
		String URL = pro.getProperty("url");
		String BROWSER = pro.getProperty("browser");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

//		WebDriver driver = new ChromeDriver();
		driver.get(URL);

	}

}
