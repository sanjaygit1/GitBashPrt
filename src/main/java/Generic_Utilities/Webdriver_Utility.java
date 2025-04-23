package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriver_Utility {

	/**
	 * this method is used to maximize the window
	 * 
	 * @param driver
	 * @author Shobha
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitElementsToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void moveToElements(WebDriver driver, WebElement ele)

	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();

	}
	
	public void windowSwitching(WebDriver driver,String partialURL)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String Url = driver.getCurrentUrl();
			System.out.println(Url);
			if (Url.contains(partialURL))

			{
				break;
			}
		}
	}
}