package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "FriendEmail")
	private WebElement emailFriendTxt;
	
	@FindBy(id = "PersonalMessage")
	private WebElement personalMessageTxt;
	
	@FindBy(name = "send-email")
	private WebElement sendemailBtn;
	
	@FindBy(css = "div.result")
	public WebElement messageNotification;
	
	
	public void SendEmailToFriend(String friendEmail, String personalMessage) {
		
		setTextElementText(emailFriendTxt, personalMessage);
		setTextElementText(personalMessageTxt, personalMessage);
		clickButton(sendemailBtn);
	}
	
	
	
	

}
