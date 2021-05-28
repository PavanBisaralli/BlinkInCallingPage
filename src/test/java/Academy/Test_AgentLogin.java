package Academy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.Page_ActionByAgent;
import pageObjects.Page_ApproveDeny;
import pageObjects.Page_Connectivity;
import pageObjects.Page_LoginPage;
import resources.base;

//My first changes
public class Test_AgentLogin extends base{
	
	static String newURL = "";

	@Test(groups= {"c1.basePageNavigation"})
	public void basePageNavigation() throws IOException, InterruptedException  
	{
		driver = initalizeDriver();

		Page_LoginPage lp = new Page_LoginPage(driver);	
		Page_Connectivity pc = new Page_Connectivity(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		driver.get("https://app.staging.blinkin.io");
		
		System.out.println("Exectuing login page");
	
		
		lp.getEmail().sendKeys("clientadmin@blinkin.io");
		lp.getPassword().sendKeys("password");
		lp.submit().click();
		
		 System.out.println("Successfully logged In");
		 
		 pc.sidebar().click();
		
		 pc.connectivity().click();
				 
		 pc.successTest().click();
		 
		 System.out.println("Executed Connectivity Events");
		 pc.sidebar().click();  

		 Assert.assertEquals(pc.gotoCallingScreen().getText(), "SEE WHAT YOUR CUSTOMERS SEE!"); 
		 
		 System.out.println(pc.gotoCallingScreen().getText());
		 
		 	newURL = pc.getJoiningUrl().getAttribute("value");
			System.out.println("Joining Link: "+ newURL);
							 
	}
	
	public String passUrl()
	{
		System.out.println("url is "+newURL);
		return newURL;
	}
	
	@Test(dependsOnGroups= {"c2.ClientJoiningCall"}, groups= {"c3.ApproveDeny"})
	public void ApproveDeny() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Page_ApproveDeny ad = new Page_ApproveDeny(driver);
		
		System.out.println("POP up display to approve user permission");
		
		ad.approveRequest().click();
		
		System.out.println("Agent Approved user permission");
		
	}
	
	@Test(dependsOnGroups= {"c4.ClientSideChat"}, groups= {"c5.ActionByAgent"})
	public void ActionByAgent() {
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Page_ActionByAgent ag = new Page_ActionByAgent(driver);
		
		String ImageUploa = prop.getProperty("ImageUpload");
		System.out.println("uploaded image is " + ImageUploa);
		
		String VideoUploa = prop.getProperty("VideoUpload");
		System.out.println("uploaded image is " + VideoUploa);
		
		System.out.println("Navigated to Agent page");
		
		ag.clickCapture().click();
		System.out.println("Successfully captured the screengrab"); 
		
		ag.clickToggleGridView().click();
		
		ag.exitToggleGridView().click();
		
		ag.clickLocation();
		System.out.println("Client location is visible");
		
		ag.clickFullScreenView();
	    System.out.println("Full screen view is expandable");
	    
	    ag.unpinUserStream();
	    System.out.println("Able to Unpin client stream");
	    
	    ag.pinUserStream();
	    System.out.println("Able to pin client stream");
	    
	    ag.clickBriefcase().click();
	    
	/*    ag.GotoScreengrabSection().click();
	    
	    ag.clickonScreengrabEdit().click();
	    
	    ag.commentOnScreengrab().sendKeys("Editing Screengrab");
	    
	    ag.saveScreengrabEdit().click();
	    System.out.println("Successfully saved edited screengrab");
	    
	    ag.clickOnExitScreengrab().click();
	    
	    
	    ag.ShareEditedScreengrab().click();
	    System.out.println("Successfully shared edit the screengrab"); */ //disabled due to page crash issue. 
	    
	    ag.clickOnChatIcon().click();
	    
	    ag.chat().sendKeys("Hi this is Admin");
	    ag.SendText().click();
		System.out.println("Messages are delivered in chat"); 
		
		ag.UploadImage().sendKeys(ImageUploa);
		ag.UploadVideo().sendKeys(VideoUploa);
	    
	  
	}
	
	@Test(dependsOnGroups= {"c5.ActionByAgent"}, groups= {"c6.end"})
	public void end() {
		driver.quit();
	}
		
}
