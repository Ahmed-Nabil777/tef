package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	String oldPassword = "123456";
	String newPassword = "12345678";
	String firstName = "nabil";
	String lastName = "elsayed";
	String email = "nabilelsayed2@gmail.com";
	//String userName = "nelsayed2777";
	
	
	
	
	@Test(priority=1)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage(driver);
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		registerObject.userRegistration(firstName,lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.closeRegistrationSuccessMssg();
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority=2)
	public void RegisteredUserCanChangePassword() throws InterruptedException
	{
		
		
		myAccountObject = new MyAccountPage(driver);
		
		registerObject.openMyAccountPage(driver);
		myAccountObject.openChangePasswordPage();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password Was Changed"));
	
		
		
	}
	@Test(priority=3)
	public void registeredUserCanLogout() throws InterruptedException {
		registerObject.userLogout(driver);
		Thread.sleep(3000);
	}
	
	
	@Test(priority=4)
	public void registeredUserCanLogin() throws InterruptedException {
		
		homeObject.openLoginPage(driver);
		Thread.sleep(3000);
		loginObject = new LoginPage(driver);
		loginObject.UserLogin(email, newPassword);
		
	}
	

}
