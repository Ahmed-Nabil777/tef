package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "Username")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(css = "input.btn.blue-button")
	WebElement loginBtn;
	
	@FindBy(xpath ="//div[@class='recaptcha-checkbox-border']")
	WebElement captchaCheckBox;
	
	
	public void UserLogin(String email, String password) throws InterruptedException
	{
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		clickButton(captchaCheckBox);
		Thread.sleep(6000);
		clickButton(loginBtn);
	}

}
