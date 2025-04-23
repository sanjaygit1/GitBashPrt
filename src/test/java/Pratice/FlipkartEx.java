package Pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Repo.MultipleAnnotations;

public class FlipkartEx {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");

		MultipleAnnotations search = new MultipleAnnotations(driver);
		search.getSearchBar().sendKeys("puma");
		search.getSearchIcon().click();
	}

}
