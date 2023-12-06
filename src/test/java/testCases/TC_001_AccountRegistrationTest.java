package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass 
{
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration() 
	{
		
		logger.info("***** Starting TC_001_AccountRegistrationTest *****");
		
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on MyAccount link *****");
		
		hp.clickRegister();
		logger.info("***** Clicked on Registration link *****");
		
		logger.info("***** Entering customer details *****");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@hotmail.com");// randomly generated the email
		regpage.setTelephone(randomNumber());
				
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("***** Clicked on continue button *****");
		
		
		String confmsg = regpage.getConfirmationAcctRegnMsg();
		logger.info("***** Validating expected confirmation message *****");
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			logger.info("test passed....");
			Assert.assertTrue(true);
		
		}
		else 
		{
			logger.error("test failed....");
			Assert.fail();
		}
		
		}//end of try block
		catch(Exception e)
		{
			logger.error("test failed....");
			Assert.fail();
		}
		
		logger.info("***** Finished TC_001_AccountRegistrationTest *****");
	}
	
}
