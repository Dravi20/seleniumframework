package Framework;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FrameworkAbstract.Abstract;
import dev.failsafe.internal.util.Assert;

public class Cartpage extends Abstract {
WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
  List< WebElement> cartprod;
	
	@FindBy(css=".totalRow button")
	   WebElement cartprodclick;
	

	public Boolean cartproduct(String productname) {
		Boolean match=  cartprod.stream().anyMatch(p->p.getText().equalsIgnoreCase(productname));
		
		return match;
	}
		public CheckOutPage checkOutPage() {
			cartprodclick.click();
			Cartpage cp = new Cartpage(driver);
		return	new CheckOutPage(driver);
		}
	
	
	
	
}
