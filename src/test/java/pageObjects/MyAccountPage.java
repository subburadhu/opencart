package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// locator webelement for message heading and logout
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") @CacheLookup  
	private WebElement msgHeadingMyAccount;
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") @CacheLookup 
	private WebElement lnkLogoutMyAccount;
	
	

	public boolean isMyAccountPageExists() 
	{
		try 
		{
			boolean msgconfirmation = msgHeadingMyAccount.isDisplayed();
			return msgconfirmation;
		}
		catch(Exception e) 
		{
			return (false);
		}
	}
	
	public void clickMyAccountLogout() 
	{
		lnkLogoutMyAccount.click();
	}

}
