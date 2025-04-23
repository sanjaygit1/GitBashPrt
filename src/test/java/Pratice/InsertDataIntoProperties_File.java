package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataIntoProperties_File {

	public static void main(String[] args) throws Throwable {

		Properties pro = new Properties();

		pro.setProperty("url", "https://www.facebook.com");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonData2pm.properties");
		pro.store(fos, "CommonData");
		System.out.println("Updated");

		// ---------------------------------------------------------------

		// step1:-setting up the physical file path
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData2pm.properties");

		// step2:-load all the keys

		pro.load(fis);

		// step3:- read the keys using getProperty()
		String URL = pro.getProperty("url");

		WebDriver driver = new ChromeDriver();
		driver.get(URL);

	}

}
