package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(name  ="removefromcart")
    WebElement removeCheck;
	
	@FindBy(name ="updatecart")
	WebElement updateCartBtn;
	
	@FindBy(css  ="input.qty-input")
	public WebElement quantityTxt;
	
	@FindBy(css  ="span.product-subtotal")
    public WebElement totalLbl;
	
	@FindBy(css  ="div.no-data")
	public WebElement EmptyCartLbl;
	

	public void removeProductFromCart()
	{
		clickButton(removeCheck);
		clickButton(updateCartBtn);
		
	}
	
	public void updateProductQuatityInCart(String quantity)
	{
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickButton(updateCartBtn);
		
	}


}
