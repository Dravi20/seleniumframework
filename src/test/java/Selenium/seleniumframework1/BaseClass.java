package Selenium.seleniumframework1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Landingpage lp;
	public WebDriver intializerDriver() throws IOException {
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Framework//resources//Global.properties");
		//FileInputStream fis = new FileInputStream("C:\\Users\\LENOVO-T440s\\eclipse-workspace\\Seleniumframework\\src\\main\\java\\Framework\\resources\\Global.properties");
		prop.load(fis);
		
		
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			//
		}
		else if(browserName.equalsIgnoreCase("edge")){
		//driver = new EdgeDriver();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	@BeforeMethod
	public Landingpage launchapplication() throws IOException {
		driver=intializerDriver();
		 lp = new Landingpage(driver);
		lp.goTo();
		return lp;
	}
	public String Scrrenshot(String testCaseName) throws IOException {
	TakesScreenshot ts =	(TakesScreenshot)driver;
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 File file = new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
	 
	 FileUtils.copyFile(source,file);
	 return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	 
	 
	}
	public List<HashMap<String,String>> getJsonDataReader(String filepath) throws IOException {
		String jsoncontent=	FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
	     });
		 return data;
		}

	@AfterMethod
	public void exit() {
		driver.close();
	}
	
}
