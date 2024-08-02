package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public  Logger logger;
	public Properties prop;
	
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"Sanity","Master","Regression","DataDriven"})
	public void setup(String os,String br) throws IOException
	{
		
		logger=LogManager.getLogger(this.getClass());
		FileReader fis=new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(fis);
		if(prop.getProperty("executionenv").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap=new DesiredCapabilities();
			
			
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);}
		else if(os.equalsIgnoreCase("linux")) {
			cap.setPlatform(Platform.LINUX);}
	else
	{
		System.out.println("No matching platform");
	return;
			}
		//browser
			switch(br.toLowerCase())
			{
			case "chrome":cap.setBrowserName("chrome");break;
			case "firefox":cap.setBrowserName("firefox");break;
			case "edge":cap.setBrowserName("MicrosoftEdge");break;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap)	;
		}
		if(prop.getProperty("executionenv").equalsIgnoreCase("local"))
		
		{
		switch(br.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
		break;
		
		case "firefox":
			driver=new FirefoxDriver();
		break;
		/*case "Edge":
			driver=new EdgeDriver();
		break;*/
		default:
			System.out.println("Invalid broswer name");
			return;
		}
		}
		//driver=new ChromeDriver();}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(prop.getProperty("url1"));
		driver.manage().window().maximize();
		
	}
	
	

	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomnumeric()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomalphanumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return (generatedString+generatednumber);
	}
	
	public String captureScreen(String tname)
	{
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetpath=System.getProperty("user.dir")+"\\screenshots"+tname+"-"+currentdatetimestamp+".png";
		File target= new File(targetpath);
		src.renameTo(target);
		return targetpath;
		
		
	}
}
