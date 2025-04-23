package product;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.CommonDataFile;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Webdriver_Utility;

public class CreateCampWithProductTest extends BaseClass {

	@Test
	public void CreateCampWithProduct() throws Throwable {

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

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.cssSelector("[src='themes/softed/images/btnL3Add.gif']")).click();

		String campName = elib.getExcelData("Sheet1", 2, 0);
		driver.findElement(By.name("campaignname")).sendKeys(campName);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();

		wlib.windowSwitching(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();

		wlib.windowSwitching(driver, "Campaigns&action");
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		String actData = driver.findElement(By.cssSelector("[id='dtlview_Campaign Name']")).getText();

		if (actData.contains(campName)) {
			System.out.println("camp name is created");
		} else {
			System.out.println("camp name is not created");
		}

//		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
//
//		wlib.moveToElements(driver, AmdLink);
//
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
