package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase
{
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath  = "//span[@class='ico-caret sprite-image']")
	WebElement loginOptionsBtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	@FindBy(linkText  = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(id  = "customerCurrency")
	WebElement currencydrl;
	
	@FindBy(linkText  = "Computers ")
	WebElement computerMenu;
	
	@FindBy(linkText  = "Notebooks ")
	WebElement notebookMenu;
	
	
	
	/*@FindBy(linkText = "Register")
	WebElement registerLink;*/
	
	
	/*@FindBy(xpath = "/html[1]/body[1]/div[6]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/ul[1]")
	List<WebElement> links;*/
	
	

	public void openRegistrationPage(WebDriver driver)
	{
		clickButton(registerLink);
		/*Actions act = new Actions(driver);
		
		act.moveToElement(loginOptionsBtn).build().perform();
		
		
		clickButton(registerLink);*/
		
		
		/*for(WebElement element: links)
		{
			if(element.getText().equals("Register"))
			{
				element.click();
				break;
			}
		}*/
		
	

	}
	public void openLoginPage(WebDriver driver)
	{
		Actions act = new Actions(driver);
		
		act.moveToElement(loginOptionsBtn).build().perform();
		
		
		clickButton(loginLink);
		
		
		/*for(WebElement element: links)
		{
			if(element.getText().equals("Register"))
			{
				element.click();
				break;
			}
		}*/
		
	

	}
	
	public void openContactUsPage()
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	public void changeCurrency()
	{
		select = new Select(currencydrl);
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebookMenu()
	{
		action.moveToElement(computerMenu).moveToElement(notebookMenu).click().build().perform();
	}
	
	
}
