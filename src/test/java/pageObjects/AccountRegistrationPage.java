package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtphone;
	
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement checkboxagree;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgCOnfirmation;
	public void SetFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
		
	}
	public void SetlastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
		
	}
	public void SetEmail(String email)
	{
		txtEmail.sendKeys(email);
		
	}
	public void SetTelephone(String phone)
	{
		txtphone.sendKeys(phone);
		
	}
	public void SetPassword(String password)
	{
		txtPassword.sendKeys(password);
		
	}
	public void SetConfirmpassword(String password)
	{
		txtConfirmPassword.sendKeys(password);
		
	}
	public void Clickagree()
	{
		checkboxagree.click();
		
	}
	public void Clickbutton()
	{
		btncontinue.click();
		
	}
	
	public String getConfirmationPage() {
		try {
			return (msgCOnfirmation.getText());}
			catch (Exception e) {
			return e.getMessage();}
		
	}
}
