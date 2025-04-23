package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sceanario {

	public static void main(String[] args) throws Throwable {

 WebDriver driver=new ChromeDriver();
 driver.get("https://www.apsrtconline.in/oprs-web/guest/home.do?h=1");
driver.manage().window().maximize();
	
Thread.sleep(1000);
driver.findElement(By.id("fromPlaceName")).sendKeys("Ban");	
	
	
	
	}

}
