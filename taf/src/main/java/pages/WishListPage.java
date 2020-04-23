package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{

	public WishListPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(css  ="td.product")
	public WebElement productCell;
	
	@FindBy(css  ="h1")
	public WebElement wishListHeader;
	
	@FindBy(name ="updatecart")
	private WebElement updateWishlistBtn;
	
	@FindBy(name  ="removefromcart")
	private WebElement removeFromCartCheck;
	
	@FindBy(css  ="div.no-data")
	public WebElement EmptyCardLbl;
	
	
	public void removeProductFromWishList()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateWishlistBtn);
		
	}
	
	

}
