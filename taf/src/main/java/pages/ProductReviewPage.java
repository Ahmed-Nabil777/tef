package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id = "addproductrating_4")
	WebElement rating4Rdobtn;
	
	@FindBy(name = "add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement reviewNotification;
	
	public void AddProductReview(String reviewTitle, String ReviewMessage) {
		
		
		setTextElementText(reviewTitleTxt, reviewTitle);
		setTextElementText(reviewTxt, ReviewMessage);
		clickButton(rating4Rdobtn);
		clickButton(submitReviewBtn);
	}


}
