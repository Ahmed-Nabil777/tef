package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contactPage;
	
	String fullName ="Test";
	String email = "ahmed@gmail.com";
	String message ="i am happy";
	
	@Test
	public void userCanUseContactUs()
	{
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, message);
		Assert.assertTrue(contactPage.successMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
		
	}
	
	
}
