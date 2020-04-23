package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class searchProductUsingAutoSuggest extends TestBase {
	
	
	String productName="Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	
	
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
    
    


}
