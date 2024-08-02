package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verifLoginDDT(String Email,String Password,String exp)
	{
		HomePage hp=new HomePage(driver);
		hp.clickMylink();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.SetEmail(Email);
		lp.SetPassword(Password);
		lp.clickogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean account=map.MyAccount();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(account==true)
			{
				Assert.assertTrue(true);
				map.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(account==true)
			{
				map.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
}
