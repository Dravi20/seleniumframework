package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkAbstract.Abstract;

public class Landingpage extends Abstract {
WebDriver driver;
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
   WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwd;
	
	@FindBy(name="login")
	WebElement login;
	//div[@aria-label='Incorrect email or password.']
	//.ng-tns-c4-4.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	@FindBy(css="[class*='flyInOut']")
	WebElement error;
	
	public Productcartlauge loginpage(String user,String pass) {
		useremail.sendKeys(user);
		passwd.sendKeys(pass);
		login.click();
		Productcartlauge pc = new Productcartlauge(driver);
		return pc;
	}
	public String errormessage() {
		waitForElements(error);
		return error.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");

	}

	
}
