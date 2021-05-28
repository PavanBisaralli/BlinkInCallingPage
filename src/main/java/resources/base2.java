package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base2 {

	public WebDriver driverClient;
	public Properties prop;

	public WebDriver initalizeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP\\eclipse-workspace\\BlinkIn\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println("browserName is " + browserName);

		String hub = prop.getProperty("hub");
		System.out.println("hub is " + hub);
		

		if (browserName.equals("chrome")) {
			System.out.println("Chrome Driver is called 1st ");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap =DesiredCapabilities.chrome();
			cap.setPlatform(Platform.WINDOWS);
			
			cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("use-fake-device-for-media-stream");
			 options.addArguments("use-fake-ui-for-media-stream");
			 	Map < String, Object > prefs = new HashMap < String, Object > ();
			    Map < String, Object > profile = new HashMap < String, Object > ();
			    Map < String, Object > contentSettings = new HashMap < String, Object > ();
			    
			 // SET CHROME OPTIONS
			    // 0 - Default, 1 - Allow, 2 - Block
			    contentSettings.put("geolocation", 1);
			    profile.put("managed_default_content_settings", contentSettings);
			    prefs.put("profile", profile);
			    options.setExperimentalOption("prefs", prefs);
			    
			 // SET CAPABILITY
			    cap.setCapability(ChromeOptions.CAPABILITY, options);
			    driverClient = new RemoteWebDriver(new URL("http://192.168.0.177:4444/wd/hub"), cap);
			    driverClient.manage().window().maximize();
			 
		}

		else if (browserName.equals("edge")) {

			System.out.println("Edge Driver is called ");
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\HP\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
			driverClient = new EdgeDriver();
		} else {

			System.out.println("Finally Driver is called ");
		}

//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driverClient;
	}

}
