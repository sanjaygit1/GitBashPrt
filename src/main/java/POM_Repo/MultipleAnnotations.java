package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class MultipleAnnotations {

	public MultipleAnnotations(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({@FindBy(css = "[type='text']"),@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")})
	private WebElement searchBar;
	
	@FindAll({@FindBy(xpath = "//button[@type='submit']"),@FindBy(className = "_2iLD__")})
	private WebElement searchIcon;

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	
	}

