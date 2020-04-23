package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage(driver);
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		registerObject.userRegistration("ahmed", "koko", "ahkdfr1857@gmail.com", "ko4ko@123");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.closeRegistrationSuccessMssg();
		Thread.sleep(3000);
		
		
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"} )
	public void registeredUserCanLogout() throws InterruptedException {
		registerObject.userLogout(driver);
		Thread.sleep(3000);
	}
	
	
	@Test(dependsOnMethods = {"registeredUserCanLogout"} )
	public void registeredUserCanLogin() throws InterruptedException {
		
		homeObject.openLoginPage(driver);
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		loginObject.UserLogin("afo0789k34", "koko@123");
		
	}

}
