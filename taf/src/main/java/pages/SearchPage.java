package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id ="small-searchterms")
	WebElement searchTxtBox;
	
	
	@FindBy(css  ="input.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id ="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText  ="Apple MacBook Pro 13-inch")
	WebElement productTitle;

	
	
	public void ProductSearch(String productName)
	{
		setTextElementText(searchTxtBox, productName);
		clickButton(searchBtn);
	}
	public void OpenProductDetailsPage()
	{
		
		clickButton(productTitle);
	}
	public void ProductSearchUsingAutoSuggest(String searchTxt)
	{
		setTextElementText(searchTxtBox, searchTxt);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickButton(productList.get(0));
		
		
	}
	

}
