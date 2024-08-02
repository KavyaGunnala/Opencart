package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement lnkAccount;
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	public void clickMylink()
	{
		lnkAccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
