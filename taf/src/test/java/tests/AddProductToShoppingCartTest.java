package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	
	String productName="Apple MacBook Pro 13-inch";
	

	
	
    @Test(priority =1)
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
    @Test(priority =2)
    public void UserCanAddProductToShoppingCart() throws InterruptedException
    {
    	
    
    	detailsObject = new ProductDetailsPage(driver);
    	detailsObject.AddToCart();
    	Thread.sleep(2000);
    	driver.navigate().to("https://demo.nopcommerce.com" + "/cart");
    	Thread.sleep(2000);
    	cartObject = new ShoppingCartPage(driver);
    	Assert.assertTrue(cartObject.totalLbl.getText().contains("$3,600.00"));
    	//Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
   
    	
    }
    @Test(priority =3)
    public void UserCanRemoveProductFromCart()
    {
    	
    
    	
    	cartObject = new ShoppingCartPage(driver);
    	cartObject.removeProductFromCart();
    	
    	Assert.assertTrue(cartObject.EmptyCartLbl.getText().contains("Your Shopping Cart is empty!"));
    	
    }
    


}
