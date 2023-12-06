package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// locator webelement link on Home Page for myaccount and register
	
	@FindBy(xpath="//input[@id='input-email']") @CacheLookup 
	private WebElement txtInputEmail;
		
	@FindBy(xpath="//input[@id='input-password']") @CacheLookup 
	private WebElement txtInputPassword;
	
	@FindBy(xpath="//input[@value='Login']") @CacheLookup 
	private WebElement lnkLoginPage;
	
	public void setInputTxtEmail(String email) 
	{
		txtInputEmail.sendKeys(email);
	}
	
	public void setInputTxtPassword(String pwd) 
	{
		txtInputPassword.sendKeys(pwd);
	}
	
	public void clickLoginButtonPage() 
	{
		lnkLoginPage.click();
	}
	
	
	
}
