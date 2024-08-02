package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[text()='My Account']")
	WebElement txtMyAccount ;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	public boolean MyAccount()
	{
	return txtMyAccount.isDisplayed();}
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
