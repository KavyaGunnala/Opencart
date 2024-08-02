package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.AccountRegistrationPage;
import pageObjects.BasePage;

public class TC001TestAccountRegistrationPage extends BaseClass {

	
	@Test(groups= {"Sanity","Master"})
	public void tc001registraion()
	{
		
		try {
		logger.info("*****Starting TC001Test Account Registration Page*********");
		HomePage hp=new HomePage(driver);
		hp.clickMylink();
		hp.clickRegister();
		logger.info("Cicked on My Account Page");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer info");
		regpage.SetFirstName(randomString().toUpperCase());
		regpage.SetlastName(randomString().toUpperCase());
		regpage.SetEmail(randomString()+"@gmail.com");
		regpage.SetTelephone(randomnumeric());
		String password=randomalphanumeric();
		regpage.SetPassword(password);
		regpage.SetConfirmpassword(password);
		regpage.Clickagree();
		regpage.Clickbutton();
		logger.info("Entered all details and clicked on continue button");
		String msgconfirmation=regpage.getConfirmationPage();
		Assert.assertEquals(msgconfirmation, "Your Account Has Been Created!");
		logger.info("Account has been created");
		}
		catch(Exception E)
		{
			logger.error("Testcase Failed");
			logger.debug("Get debug logs");
			Assert.fail();
		}
		logger.info("Testcase Executed");
	}
	
}
