package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	// locator webelement link on Home Page for myaccount and register
	
	@FindBy(xpath="//span[normalize-space()='My Account']") @CacheLookup 
	private WebElement lnkMyAccount;
	
	
	
	@FindBy(xpath="//a[@title='My Account']") @CacheLookup //added new myaccont link for tc006
	private WebElement lnkMyAcct;
	
	@FindBy(xpath="//a[normalize-space()='Register']") @CacheLookup 
	private WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']") @CacheLookup 
	private WebElement lnkHomePageLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;
	
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	// action performed for web elements
	public void clickMyAccount() 
	{
		lnkMyAccount.click();
	}

	
	public void clickOnMyAccount() //for TC006 link 
	{
		lnkMyAcct.click();
	}
	
	public void clickRegister() 
	{
		lnkRegister.click();
	}
	
	public void clickHomePageLogin() 
	{
		lnkHomePageLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
}
