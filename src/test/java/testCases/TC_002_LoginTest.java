package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	
	@Test(groups= {"sanity","master"})
	public void verify_LoginTest() 
	{
		
		logger.info("***** Starting TC_002_LoginTest *****");
		logger.debug("***** Capturing application debug logs *****");
		
		try 
		{			
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***** Clicked on MyAccount link  *****");
			hp.clickHomePageLogin();
			logger.info("***** Clicked on login link  *****");
			
			//Login Page
			LoginPage lp = new LoginPage(driver);
			logger.info("***** Entering valid email and password from config file  *****");
			
			lp.setInputTxtEmail(properties.getProperty("email"));
			lp.setInputTxtPassword(properties.getProperty("password"));
			
			lp.clickLoginButtonPage();
			
			logger.info("***** Clicked on login button  *****");
			
			//My Account Page
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPageMsg = map.isMyAccountPageExists();
			System.out.println("confirmation message is: " + targetPageMsg);
			
			if(targetPageMsg==true)
			{
				map.clickMyAccountLogout();
				logger.info("Login test passed");
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("Login test passed");
				Assert.fail();
			}
			
		}//try
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC_002_LoginTest *****");
	}//end of verify_LoginTest method

}
