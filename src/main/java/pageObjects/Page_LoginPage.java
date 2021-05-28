package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_LoginPage {

	public WebDriver driver;
	
	By email = By.xpath("//*[@type='text']");
	By password = By.xpath(("//*[@type='password']"));
	By submit = By.cssSelector("button.px-3.btn.btn-primary");
	By sidebar = By.cssSelector("button.sidebar-minimizer.mt-auto");
	By connectivity = By.xpath("//a[@href='#/connectivity']");
	By successTest = By.xpath("//button[@class='btn btn btn-primary btn-block' and contains(text(), 'I have sound and video')]");
	By callingscreen = By.xpath("//li[@class='callingScreenHints'][1]");
	By joiningurl = By.xpath("//div[@class='input-group']/input[@class='form-control']");
	
	
	
	public Page_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	

	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement submit() 
	{
		return driver.findElement(submit);
	}
	
	public WebElement sidebar() 
	{
		return driver.findElement(sidebar);
	}
	
	public WebElement connectivity() 
	{
		return driver.findElement(connectivity);
	}
	
	public WebElement successTest() 
	{
		return driver.findElement(successTest);
	}
	
	public WebElement gotoCallingScreen() 
	{
		return driver.findElement(callingscreen);
	}
	
	public WebElement getJoiningUrl() 
	{
		return driver.findElement(joiningurl);
	}
}
