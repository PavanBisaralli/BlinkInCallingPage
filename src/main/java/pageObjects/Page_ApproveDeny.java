package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_ApproveDeny {

	public WebDriver driver;
	
	By Approve = By.xpath("//button[@class='btn btn-success btn-sm']");
	
	
	public Page_ApproveDeny(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	public WebElement approveRequest() 
	{
		return driver.findElement(Approve);
	}
}
