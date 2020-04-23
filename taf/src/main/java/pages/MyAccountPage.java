package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	 WebElement oldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	 WebElement newPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	 WebElement confirmPasswordTxt;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Change password']")
	 WebElement changePasswordBtn;
	
	@FindBy(css = "div.result")
	public WebElement resultLbl;
	
	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword)
	{
		setTextElementText(oldPasswordTxt, oldPassword);
		setTextElementText(newPasswordTxt, newPassword);
		setTextElementText(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
	}

}
