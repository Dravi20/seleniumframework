package Selenium.Seleniumframework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Framework.Cartpage;
import Framework.CheckOutPage;
import Framework.ConformPage;
import Framework.Productcartlauge;
import Selenium.seleniumframework1.BaseClass;

public class Standedalone3 extends BaseClass {
@Test
public void SubmitOrder() throws IOException {
		String productname = ("ADIDAS ORIGINAL");
		WebDriver driver = null ;
		//Landingpage lp	= launchapplication();
		//Landingpage lp = new Landingpage(driver);	
		Productcartlauge pc=		lp.loginpage("dekkaravikumar20@gmail.com", "Dravi@20");
		//Productcartlauge pc = new Productcartlauge(driver);
		List<WebElement> prod = pc.getProductList();
			pc.addproductcart(productname);
	//	Cartpage cp = new Cartpage(driver);
			Cartpage cp=	 pc.addToCartPage();	
		Boolean match = cp.cartproduct(productname);
		Assert.assertTrue(match);
		CheckOutPage cop=	cp.checkOutPage();
	//	CheckOutPage cop = new CheckOutPage(driver);
		cop.country("india");
		ConformPage cps=	cop.submitorder();
	//	ConformPage cps = new ConformPage(driver);
		cps.Conform();
		String mssg = cps.Conform();
		Assert.assertTrue(mssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	

}
