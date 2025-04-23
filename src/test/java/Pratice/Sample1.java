package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1 {

	public static void main(String[] args) throws Throwable {

WebDriver driver=new ChromeDriver();
driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation");
driver.manage().window().maximize();
driver.findElement(By.id("email_create")).sendKeys("shobharani0596@gmail.com");
driver.findElement(By.xpath("//i[@class='icon-user left']")).click();

Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@for='id_gender1']")).click();
	
	}

}
