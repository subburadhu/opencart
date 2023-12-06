package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	@Parameters({"os", "browser"})
	@BeforeClass(groups= {"sanity","regression","master"})
	public void setup(String os, String br) throws IOException 
	{
		
		//location of properties file
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		//System.out.println("file path is... :" + System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		properties = new Properties();
		//Loading properties file
		properties.load(file);
		
		//Loading log4j2.xml file
		logger = LogManager.getLogger(this.getClass());
		
		//setting selenium grid act as standalone with same machine as hub and node
		// this following code will work for both standalone and remote machine
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote")) 
		{
			DesiredCapabilities cap = new DesiredCapabilities();

			//OS
			
			if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WINDOWS);
				
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS...");
				return;
			}
			
			//Browser setting
			switch(br.toLowerCase())
			{
				case "chrome": cap.setBrowserName("chrome"); break;
				case "edge":   cap.setBrowserName("MicrosoftEdge"); break;
				default: System.out.println("No matching browser..."); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
		}
		
		else if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase()) 
			{
				case "chrome": driver = new ChromeDriver(); break;
				case "edge": driver = new EdgeDriver(); break;
				default: System.out.println("No matching browser");
				return;
			}
		}
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/index.php");
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	public String randomString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() 
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String randomAlphaNumeric() 
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);	
		return(str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots" +"\\" + tname+ "_" + timeStamp + ".png";
		System.out.println("screenshot file path is: " + targetFilePath);
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() 
	{
		driver.quit();
	}
	
}
