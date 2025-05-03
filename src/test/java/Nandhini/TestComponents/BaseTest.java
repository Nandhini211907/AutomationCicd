package Nandhini.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Nandhini.landingpage.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
  
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver intialize() throws IOException {
	
	Properties Prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Nandhini//resources//GlobalData.properties");
	Prop.load(fis);
	String browsername = System.getProperty("browser") != null ? System.getProperty("browser") : Prop.getProperty("browser");
	// = Prop.getProperty("browser");
		if(browsername.contains("chrome"))	{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
				 options.addArguments("headless");	
			}
          driver = new ChromeDriver(options);
          driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browsername.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Nandhini\\Downloads\\edgedriver_win64\\msedgedriver.exe\\");
			WebDriver driver = new EdgeDriver();
} 
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public List<HashMap<String, String>> getjsondata(String filePath) throws IOException{
		 String jsonContent =  FileUtils.readFileToString(new File(filePath),
				 StandardCharsets.UTF_8);
	     ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			 
		 });
		 return data;
	   }
	
	 public String getScreenshot(String testCaseName , WebDriver driver) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File file = new File(System.getProperty("user.dir")+"//reports//" +testCaseName+ ".png");
	        FileUtils.copyFile(source, file);
	        return System.getProperty("user.dir")+"//reports//" +testCaseName+".png";
	    }
	    
	@BeforeMethod(alwaysRun=true)
	public LandingPage landing() throws IOException {
		driver = intialize();
	    landingpage = new LandingPage(driver);
		landingpage.landingV();
		return landingpage;
		
	}
	@AfterMethod(alwaysRun=true)
	public void close() {
		driver.close();
	}
}
