package Selenium.Seleniumframework;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standedalone2 {

	public static void main(String[] args) throws InterruptedException {
		String productname = ("ADIDAS ORIGINAL");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Landingpage lp = new Landingpage(driver);
			lp.loginpage("dekkaravikumar20@gmail.com","Dravi@20");
			lp.goTo();
		
		
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		   
	List<WebElement>	prod =driver.findElements(By.cssSelector(".mb-3"));
	WebElement prods=     prod.stream().filter(product->
	     product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	     prods.findElement(By.cssSelector(".btn.w-10.rounded")).click();
	     
	  
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	     wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	     
	     driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	     
	  List<WebElement> cartproduct=  driver.findElements(By.cssSelector(".cartSection h3"));
	Boolean match=  cartproduct.stream().anyMatch(p->p.getText().equalsIgnoreCase(productname));
	Assert.assertTrue( match);
	
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	//driver.findElement(By.cssSelector(".form-group input")).sendKeys("ind");
	/*
	 * List<WebElement> dp=driver.findElements(By.cssSelector(".ng-star-inserted"));
	 * for(WebElement option:dp) { if(option.getText().equalsIgnoreCase("India")) {
	 * option.click(); break;
	 * 
	 * } }
	 */
   Actions a= new Actions(driver);
   a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
   Thread.sleep(2000);
   driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
   
	driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
	
String mssg =	driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(mssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
