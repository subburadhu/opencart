package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	
	@Test(groups= {"master"}, dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDTTest(String email,String password,String expresult) 
	{
		
		logger.info("***** Starting TC_003_LoginDDTTest *****");
		
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
			logger.info("***** Entering email and password from excel file via dataprovider  *****");
			
			lp.setInputTxtEmail(email);
			lp.setInputTxtPassword(password);
			
			lp.clickLoginButtonPage();
			
			logger.info("***** Clicked on login button  *****");
			
			//My Account Page
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPageMsg = map.isMyAccountPageExists();
			System.out.println("myaccount page confirmation message is: " + targetPageMsg);
			
			//validating positive test case scenario
			if(expresult.equalsIgnoreCase("Valid")) 
			{
				if(targetPageMsg==true)
				{
					map.clickMyAccountLogout();
					logger.info("Login test passed");
					Assert.assertTrue(true);
				}
				else 
				{
					logger.info("Login test failed");
					Assert.assertTrue(false);
				}
			}
			//Validating negative test case scenario 
			if(expresult.equalsIgnoreCase("Invalid")) 
			{
				if(targetPageMsg==true)
				{
					map.clickMyAccountLogout();
					Assert.assertTrue(false);
				}
				else 
				{
					Assert.assertTrue(true);
				}
			}
			
		} // end of try block
		catch(Exception e) 
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC_003_LoginDDTTest *****");
	}//end of loginddt test method
	
}
