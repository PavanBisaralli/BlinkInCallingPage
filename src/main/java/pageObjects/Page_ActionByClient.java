package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page_ActionByClient {

	public WebDriver driverClient;
	
	
	By client_Capture = By.xpath("//i[@class='fa fa-camera fa-fw']"); 
	By client_ToggleGridView = By.xpath("//button[@id='gridIconButton']");
	By client_CloseToggleGridView = By.xpath("//button[@class='btn btn-link btn-sm']");
	By client_location = By.xpath("//button[@class='btn btn-link hideWhenSmall'][3]");
	By client_fullScreenView = By.xpath("//button[@class='btn btn-link hideWhenSmall'][2]");
	By client_UnpinStream = By.xpath("//button[@class='btn btn-link'][2]");
	By client_pinStream = By.xpath("//button[@class='btn btn-link'][2]");
	By client_briefcase = By.xpath("//i[@class='fa fa-briefcase']"); 
	By commentSection = By.xpath("//textarea[@id='comment']"); 
	By chatSubmit = By.xpath("//i[@class='fa fa-paper-plane-o']"); 
	By ImageUpload = By.xpath("//input[@type= 'file']");
	By VideoUpload = By.xpath("//input[@type= 'file']");
	
	public Page_ActionByClient(WebDriver driverClient) {
		// TODO Auto-generated constructor stub
		
		this.driverClient=driverClient;
	}
	
	public WebElement client_clickCapture() 
	{
		return driverClient.findElement(client_Capture);
	}
	

	public WebElement client_clickToggleGridView() 
	{
		return driverClient.findElement(client_ToggleGridView);
	}
	
	public WebElement client_exitToggleGridView() 
	{
		return driverClient.findElement(client_CloseToggleGridView);
	}
	
	
	public void client_clickLocation() 
	{
		Actions action = new Actions(driverClient);
		WebElement loc = driverClient.findElement(client_location);
	    
	    action.moveToElement(loc);
	    action.click().build().perform(); 
	}
	
	
	public void client_clickFullScreenView() 
	{
		Actions action = new Actions(driverClient);
  
		WebElement fullScreen = driverClient.findElement(client_fullScreenView);
	    
	    action.moveToElement(fullScreen);            //cehck full screen view option
	    action.click().build().perform();  
	    action.sendKeys(Keys.ESCAPE).build().perform(); 
		
	}
	
	
	public void client_unpinUserStream() 
	{
		Actions action = new Actions(driverClient);
		WebElement Unpin = driverClient.findElement(client_UnpinStream);
	    
	    action.moveToElement(Unpin);                         //cehck pin/unpin option
	    action.click().build().perform();
	    
	}
	
	public void client_pinUserStream() 
	{
		Actions action = new Actions(driverClient);
		WebElement pin =  driverClient.findElement(client_pinStream);
	    
	    action.moveToElement(pin);                         //cehck pin/unpin option
	    action.click().build().perform();
	}
	
	public WebElement client_briefcase() 
	{
		return driverClient.findElement(client_briefcase);
	}
	
	public WebElement chat() 
	{
		return driverClient.findElement(commentSection);
	}
	
	public WebElement SendText() 
	{
		return driverClient.findElement(chatSubmit);
	}
	
	public WebElement UploadImage() 
	{
		return driverClient.findElement(ImageUpload);
	}
	
	public WebElement UploadVideo() 
	{
		return driverClient.findElement(VideoUpload);
	}
}
