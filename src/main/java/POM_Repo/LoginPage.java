package POM_Repo;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement UserTextField;

	@FindBy(name = "user_password")
	private WebElement PassWordTextField;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void logintoApp(String UserName,String PassWord)
	{
		UserTextField.sendKeys(UserName);
		PassWordTextField.sendKeys(PassWord);
		loginButton.click();
	}
	
}
