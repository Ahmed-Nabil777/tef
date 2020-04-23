package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWhishlistTest extends TestBase {
	

	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	WishListPage wishlistObject;
	
	
    @Test(priority =1)
    public void UserCanSearchWithAutoSuggest()
    {
    	
    	
    	searchObject = new SearchPage(driver);
    	searchObject.ProductSearchUsingAutoSuggest("mac");
    	detailsObject = new ProductDetailsPage(driver);
    	Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
    	
    }
    @Test(priority =2)
    public void UserCanAddProductTowishList()
    {
    	
    
    	detailsObject = new ProductDetailsPage(driver);
    	detailsObject.AddProductToWhishList();
    	driver.navigate().to("https://demo.nopcommerce.com" + "/wishlist");
    	wishlistObject = new WishListPage(driver);
    	Assert.assertTrue(wishlistObject.wishListHeader.isDisplayed());
    	Assert.assertTrue(wishlistObject.productCell.getText().contains(productName));
   
    	
    }
    @Test(priority =3)
    public void UserCanRemoveProductFromCart()
    {
    	
    
    	
    	wishlistObject = new WishListPage(driver);
    	wishlistObject.removeProductFromWishList();
    	
    	Assert.assertTrue(wishlistObject.EmptyCardLbl.getText().contains("The wishlist is empty!"));
    	
    }
    
    	

    }


