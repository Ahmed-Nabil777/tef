package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNameBreadCrumb;
	
	@FindBy(css = "input.button-2.email-a-friend-button valid")
	public WebElement emailFriendBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement productPricelbl;
	
	@FindBy(linkText  = "Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id  = "add-to-wishlist-button-4")
	public WebElement addToWhishListBtn;
	
	@FindBy(id  = "add-to-cart-button-4")
	public WebElement addToCartBtn;
	
	
	
	
	
	
	
	
	
    public void openSendMail()
    {
    	clickButton(emailFriendBtn);
    }
    
    public void openAddReviewPage()
    {
    	clickButton(addReviewLink);
    }
    
    public void AddProductToWhishList()
    {
    	clickButton(addToWhishListBtn);
    }
    
    public void AddToCart()
    {
    	clickButton(addToCartBtn);
    }
    
	

}
