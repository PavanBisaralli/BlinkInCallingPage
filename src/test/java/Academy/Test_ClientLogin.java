package Academy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Page_ClientLogin;
import pageObjects.Page_ActionByClient;
import resources.base2;


public class Test_ClientLogin extends base2 {

	
	@Test(dependsOnGroups= {"c1.basePageNavigation"}, groups= {"c2.ClientJoiningCall"})
	public void ClientJoiningCall() throws IOException {
		
		driverClient = initalizeDriver();
		driverClient.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		Test_AgentLogin agent = new Test_AgentLogin();
		String urlClient = agent.passUrl();

		if (!urlClient.isEmpty()) {
			System.out.println(" not empty url in client is " + urlClient);
		
			Page_ClientLogin cl = new Page_ClientLogin(driverClient); 
			
			driverClient.get(urlClient);
			
			cl.selectCheckbox().click();
			cl.proceed().click();
			cl.clientUsername().sendKeys("Client1");
			cl.clientUserEmail().sendKeys("Client1@g.com");
			cl.confirm().click();
			System.out.println("Submitted Client details");
	}
}
	@Test(dependsOnGroups= {"c3.ApproveDeny"}, groups= {"c4.ClientSideChat"})
	public void ClientSideChat() throws IOException {
		
		
		driverClient.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Page_ActionByClient cs = new Page_ActionByClient(driverClient);
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\BlinkIn\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String ImageUploa = prop.getProperty("ImageUpload");
		System.out.println("uploaded image is " + ImageUploa);
		
		String VideoUploa = prop.getProperty("VideoUpload");
		System.out.println("uploaded image is " + VideoUploa);
		
		System.out.println("switch to client after agent approval");
		
		cs.client_clickCapture().click();
		System.out.println("Successfully captured the screengrab"); 
		
		cs.client_clickToggleGridView().click();
		
		cs.client_exitToggleGridView().click();
		
		cs.client_clickLocation();
		System.out.println("Client location is visible");
		
		cs.client_clickFullScreenView();
	    System.out.println("Full screen view is expandable");
	    
	    cs.client_unpinUserStream();
	    System.out.println("Able to Unpin client stream");
	    
	    cs.client_pinUserStream();
	    System.out.println("Able to pin client stream");
		
		cs.client_briefcase().click();
		cs.chat().sendKeys("Hi this is Client");
		cs.SendText().click();
		System.out.println("Messages are delivered in chat"); 
		
		cs.UploadImage().sendKeys(ImageUploa);
		cs.UploadVideo().sendKeys(VideoUploa);
		
	}
	
	@Test(dependsOnGroups= {"c6.end"})
	public void endClient() {
		driverClient.quit();
	}
	
	
}