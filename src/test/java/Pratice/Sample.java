package Pratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) throws AWTException {

 WebDriver driver=new ChromeDriver();
 driver.get("https://demoqa.com/automation-practice-form");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.manage().window().maximize();
 
//Robot rob = new Robot();
//rob.keyPress(KeyEvent.VK_PAGE_DOWN);
//rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

WebElement radio = driver.findElement(By.xpath("//label[text()='Male']"));
 
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeScript("arguments[0].scrollIntoView()",radio);
 radio.click();
//	if(radio.isEnabled())
//	{
//		radio.click();
//	}
//	else
//	{
//		System.out.println("ele is not enabled");
//	}
	
	//http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation
	}

}
