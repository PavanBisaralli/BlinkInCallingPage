package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page_ActionByAgent {
	
	public WebDriver driver;
	
	
	By Capture = By.xpath("//i[@class='fa fa-camera fa-fw']"); 
	By ToggleGridView = By.xpath("//button[@id='gridIconButton']");
	By CloseToggleGridView = By.xpath("//button[@class='btn btn-link btn-sm']");
	By location = By.xpath("//button[@class='btn btn-link hideWhenSmall'][3]");
	By fullScreenView = By.xpath("//button[@class='btn btn-link hideWhenSmall'][2]");
	By UnpinStream = By.xpath("//button[@class='btn btn-link'][2]");
	By pinStream = By.xpath("//button[@class='btn btn-link'][2]"); 
	By Briefcase = By.xpath("//i[@class='fa fa-briefcase']");
	By commentSection = By.xpath("//textarea[@id='comment']"); 
	By chatSubmit = By.xpath("//i[@class='fa fa-paper-plane-o']"); 
	By ImageUpload = By.xpath("//input[@type= 'file']");
	By VideoUpload = By.xpath("//input[@type= 'file']");
	By ScreengrabSection = By.xpath("//a[@class='nav-link']/i[@class='icon-camera']");
	By ScreengrabEdit = By.xpath("//i[@class='fa fa-pencil']");
	By ScreengrabComments = By.xpath("//textarea[@id='Comments']");
	By SaveComments = By.xpath("//button[@class='btn btn-secondary']");
	By ExitScreengrab = By.xpath("//button[@class='close']/span"); 
	By ShareScreengrab = By.xpath("//i[@class='fa fa-commenting-o']"); 
	By ChatIcon = By.xpath("//i[@class='icon-speech']");
	
	
	
	
	public Page_ActionByAgent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement clickCapture() 
	{
		return driver.findElement(Capture);
	}
	

	public WebElement clickToggleGridView() 
	{
		return driver.findElement(ToggleGridView);
	}
	
	public WebElement exitToggleGridView() 
	{
		return driver.findElement(CloseToggleGridView);
	}
	
	
	public void clickLocation() 
	{
		Actions action = new Actions(driver);
		WebElement loc = driver.findElement(location);
	    
	    action.moveToElement(loc);
	    action.click().build().perform(); 
	}
	
	
	public void clickFullScreenView() 
	{
		Actions action = new Actions(driver);
		WebElement fullScreen = driver.findElement(fullScreenView);
	    
	    action.moveToElement(fullScreen);            //cehck full screen view option
	    action.click().build().perform();  
	    action.sendKeys(Keys.ESCAPE).build().perform(); 
		
	}
	
	
	public void unpinUserStream() 
	{	
		Actions action = new Actions(driver);
		WebElement Unpin = driver.findElement(UnpinStream);
	    
	    action.moveToElement(Unpin);                         //cehck pin/unpin option
	    action.click().build().perform();
	    
	}
	
	public void pinUserStream() 
	{	
		Actions action = new Actions(driver);
		WebElement pin =  driver.findElement(pinStream);
	    
	    action.moveToElement(pin);                         //cehck pin/unpin option
	    action.click().build().perform();
	}
	
	public WebElement clickBriefcase() 
	{
		return driver.findElement(Briefcase);
	}
	
	public WebElement chat() 
	{
		return driver.findElement(commentSection);
	}
	
	public WebElement SendText() 
	{
		return driver.findElement(chatSubmit);
	}
	
	public WebElement UploadImage() 
	{
		return driver.findElement(ImageUpload);
	}
	
	public WebElement UploadVideo() 
	{
		return driver.findElement(VideoUpload);
	}
	
	public WebElement GotoScreengrabSection() 
	{
		return driver.findElement(ScreengrabSection);
	}
	
	public WebElement clickonScreengrabEdit() 
	{
		return driver.findElement(ScreengrabEdit);
	}
	
	public WebElement commentOnScreengrab() 
	{
		return driver.findElement(ScreengrabComments);
	}
	
	public WebElement saveScreengrabEdit() 
	{
		return driver.findElement(SaveComments);
	}
	
	public WebElement clickOnExitScreengrab() 
	{
		return driver.findElement(ExitScreengrab);
	}
	
	public WebElement ShareEditedScreengrab() 
	{
		return driver.findElement(ShareScreengrab);
	}
	
	
	public WebElement clickOnChatIcon() 
	{
		return driver.findElement(ChatIcon);
	}
}
