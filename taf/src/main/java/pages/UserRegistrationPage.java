package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase 
{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	/*@FindBy(id = "ConfirmEmail")
	WebElement confirmemailTxtBox;
	
	@FindBy(id = "Username")
	WebElement userTxtBox;*/
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(xpath ="//*[@id=\"bar-notification\"]/div/p" )
	public WebElement successMessage;
	
	@FindBy(xpath ="//a[text()='Log out']" )
	public WebElement logoutLink;
	
	@FindBy(xpath  = "//span[@class='ico-caret sprite-image']")
	WebElement loginOptionsBtn;
	
	@FindBy(xpath = "//span[@title='Close']")
	WebElement registrationSuccessMssg;
	
	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccount;
	
	
	public void userRegistration(String firstName, String lastName, String email, String password)
	{
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		/*setTextElementText(confirmemailTxtBox, email);
		setTextElementText(userTxtBox, userName);*/
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
		
	}
	
	public void userLogout(WebDriver driver)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(loginOptionsBtn).build().perform();
		
		
		clickButton(logoutLink);
		
		
		/*for(WebElement element: links)
		{
			if(element.getText().equals("Register"))
			{
				element.click();
				break;
			}
		}*/
		
	

	}
	public void closeRegistrationSuccessMssg() {
		clickButton(registrationSuccessMssg);
	}
	public void openMyAccountPage(WebDriver driver)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(loginOptionsBtn).build().perform();
		
		
		clickButton(myAccount);
		
		
		/*for(WebElement element: links)
		{
			if(element.getText().equals("Register"))
			{
				element.click();
				break;
			}
		}*/
		
	

	}

}
