package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002LoginTest extends BaseClass {

	
	@Test(groups= {"Regression","Master"})
	public void verifyLogin()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMylink();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(prop.getProperty("Email"));
		lp.SetPassword(prop.getProperty("Password"));
		lp.clickogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean account=map.MyAccount();
		
		Assert.assertEquals(account,true,"LoginFailed");
	}
}
