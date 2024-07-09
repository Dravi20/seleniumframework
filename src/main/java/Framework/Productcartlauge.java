package Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkAbstract.Abstract;

public class Productcartlauge extends Abstract {
WebDriver driver;
	public Productcartlauge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
  List< WebElement> products;
	
	 @FindBy(css=".ng-animating")
	 WebElement tost;
	 
	 @FindBy(css="[routerlink*='cart']")
	 WebElement addcartclick;
	 
	By product=By.cssSelector(".mb-3");
	By addcart= By.cssSelector(".btn.w-10.rounded");
    By toastmessage=	By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList() {
		waitForElement(product);
		return products;
	}
	public WebElement getproductname(String productname) {
		WebElement prods=     getProductList().stream().filter(product->
	     product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prods;
	}
	public void addproductcart(String productname) {
	WebElement prods=	getproductname(productname);
		 prods.findElement(addcart).click();
		 waitForElement(toastmessage);
		 waitForInvisibility(tost);
		 addcartclick.click();
		 
		 
	}
	
	
	
	
}
