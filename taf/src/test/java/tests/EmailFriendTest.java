package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	EmailFriendPage emailObject;
	
	
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage(driver);
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		registerObject.userRegistration("nabil", "kokonabil", "af85kk7@gmail.com", "af4o023789k34");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		/*registerObject.closeRegistrationSuccessMssg();
		Thread.sleep(3000);*/
		
		
	}
	
	
	@Test(priority=2)
    public void UserCanSearchWithAutoSuggest()
    {
    	
    	try {
    	searchObject = new SearchPage(driver);
    	searchObject.ProductSearchUsingAutoSuggest("mac");
    	detailsObject = new ProductDetailsPage(driver);
    	Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));}
    	
    	catch(Exception e) {
    		
    		System.out.println("Error " + e.getMessage());
    		
    	}
    }
	
	@Test(priority=3)
	public void RegisteredUserCanSendProductToFriend()
	{
		detailsObject.openSendMail();
		emailObject = new EmailFriendPage(driver);
		emailObject.SendEmailToFriend("ahmed@gmail.com", "hello");
		Assert.assertTrue(emailObject.messageNotification.getText().equalsIgnoreCase("Your message has been sent."));
		
	}
	
	@Test(priority=4)
	public void registeredUserCanLogout() throws InterruptedException {
		registerObject.userLogout(driver);
		Thread.sleep(3000);
	}
	
	

}
