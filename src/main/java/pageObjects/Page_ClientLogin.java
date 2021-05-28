package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_ClientLogin {
	
	public WebDriver driverClient;
	
	By switchSlider = By.xpath("//span[@class='switch-slider']"); 
	By disclaimerProceed = By.xpath("//button[@id='discalimerProcced']");
	By username = By.xpath("//input[@id='username']"); 
	By userEmail = By.xpath("//input[@id='email']"); 
	By confirm = By.xpath("//button[@class='swal2-confirm swal2-styled']"); 
	
	
	public Page_ClientLogin(WebDriver driverClient) {
		
		this.driverClient = driverClient; 
	}
	
	public WebElement selectCheckbox() 
	{
		return driverClient.findElement(switchSlider);
	}
	
	public WebElement proceed() 
	{
		return driverClient.findElement(disclaimerProceed);
	}
	
	public WebElement clientUsername() 
	{
		return driverClient.findElement(username);
	}
	
	public WebElement clientUserEmail() 
	{
		return driverClient.findElement(userEmail);
	}
	
	public WebElement confirm() 
	{
		return driverClient.findElement(confirm);
	}
	
}
