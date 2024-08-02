package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLogin;
	
	public void SetEmail(String Email) {
	txtEmail.sendKeys(Email);}
	
	public void SetPassword(String pwd) {
		txtPassword.sendKeys(pwd);}
	
	public void clickogin() {
		btnLogin.click();}
}
