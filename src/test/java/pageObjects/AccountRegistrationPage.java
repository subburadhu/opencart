package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}

	
	// locator web elements on Registration Page
	
	@FindBy(xpath="//input[@id='input-firstname']") @CacheLookup 
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") @CacheLookup 
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']") @CacheLookup 
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']") @CacheLookup 
	private WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']") @CacheLookup 
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']") @CacheLookup 
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") @CacheLookup 
	private WebElement chkdPolicyAgree;
	
	@FindBy(xpath="//input[@value='Continue']") @CacheLookup 
	private WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") @CacheLookup 
	private WebElement msgConfirmationAcctRegn;
	
	// action performed for web elements
	
	public void setFirstName(String fname) 
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) 
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confirmpwd) 
	{
		txtConfirmPassword.sendKeys(confirmpwd);
	}
	
	public void setPrivacyPolicy() 
	{
		chkdPolicyAgree.click();
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public String getConfirmationAcctRegnMsg() 
	{
		try 
		{
			return (msgConfirmationAcctRegn.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
