package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	ProductReviewPage reviewObject;
	
	
	
	
	@Test(priority=1, alwaysRun=true)
	public void UserCanRegisterSuccessfully() throws InterruptedException
	{
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage(driver);
		registerObject = new UserRegistrationPage(driver);
		Thread.sleep(3000);
		registerObject.userRegistration("nabil", "kokonabil", "af85dkk7@gmail.com", "af4o0d23789k34");
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
	public void RegisteredUserCanSendReviewProduct()
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.AddProductReview("Test", "go to hell");
		Assert.assertTrue(reviewObject.reviewNotification.getText().equalsIgnoreCase("Product review is successfully added."));
		
	}
	
	@Test(priority=4)
	public void registeredUserCanLogout() throws InterruptedException {
		registerObject.userLogout(driver);
		Thread.sleep(3000);
	}
	
	

}



