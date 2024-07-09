package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkAbstract.Abstract;

public class CheckOutPage extends Abstract {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectcountry;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement clickcountry;
	
	@FindBy(css=".action__submit")
	WebElement clickbutton;
	
	public CheckOutPage country(String countryname) {
		Actions a= new Actions(driver);
		a.sendKeys(selectcountry,countryname).build().perform();
		clickcountry.click();
		CheckOutPage cop = new CheckOutPage(driver);
		return cop;
	}
	public ConformPage submitorder() {
		
		clickbutton.click();
		return new ConformPage(driver);
	}
}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	