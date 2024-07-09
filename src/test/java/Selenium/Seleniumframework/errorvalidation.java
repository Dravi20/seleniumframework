package Selenium.Seleniumframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.Cartpage;
import Framework.CheckOutPage;
import Framework.ConformPage;
import Framework.Productcartlauge;
import Selenium.seleniumframework1.BaseClass;
import Selenium.seleniumframework1.Retry;

      public class errorvalidation extends BaseClass {
    	  String productname = ("ADIDAS ORIGINAL");
     @Test  (retryAnalyzer=Retry.class)
   public void SubmitOrder()  {
		
		
				lp.loginpage("dekkaravikumar20@gmail.com", "Dravi20");
	Assert.assertEquals("Incorrect email or password.", lp.errormessage());	
		
	}
     @Test

     public void ErrorSubmitOrder() throws IOException {
     		
     	WebDriver driver = null ;
     		
    Productcartlauge pc=		lp.loginpage("dekkaravikumar21@gmail.com", "Dravi@97");
     	
     			
     		List<WebElement> prod = pc.getProductList();
     			pc.addproductcart(productname);
     	
     			Cartpage cp=	 pc.addToCartPage();	
     		Boolean match = cp.cartproduct(productname);
     		Assert.assertTrue(match);
     		CheckOutPage cop=	cp.checkOutPage();
     	
     		cop.country("india");
     		ConformPage cps=	cop.submitorder();
     
     		cps.Conform();
     		
     	}
   

     }




	


