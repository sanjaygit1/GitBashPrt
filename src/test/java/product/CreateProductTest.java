package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import Generic_Utilities.BaseClass;
import Generic_Utilities.CommonDataFile;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Webdriver_Utility;

public class CreateProductTest extends BaseClass {

	@Test
	public void  CreateProductTest() throws Throwable {
		Webdriver_Utility wlib = new Webdriver_Utility();
		
		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

		// To Avoid Duplicates
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);

		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.getExcelData("Sheet1", 0, 0) + ranNum;

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		if (actData.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

//		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//
//		wlib.moveToElements(driver, AmdLink);
//
//		driver.findElement(By.linkText("Sign Out")).click();

		
	}

}
