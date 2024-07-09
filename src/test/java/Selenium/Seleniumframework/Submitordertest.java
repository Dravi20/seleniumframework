package Selenium.Seleniumframework;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.Cartpage;
import Framework.CheckOutPage;
import Framework.ConformPage;
import Framework.OrderPage;
import Framework.Productcartlauge;
import Selenium.seleniumframework1.BaseClass;
import Selenium.seleniumframework1.Retry;

public class Submitordertest extends BaseClass {
	String productname = ("ADIDAS ORIGINAL");

	@Test(dataProvider="getdata",retryAnalyzer=Retry.class)
	public void SubmitOrder(HashMap<String,String> input) {

		Productcartlauge pc = lp.loginpage(input.get("email"), input.get("password"));
		List<WebElement> prod = pc.getProductList();
		pc.addproductcart(productname);
		Cartpage cp = pc.addToCartPage();
		Boolean match = cp.cartproduct(productname);
		Assert.assertTrue(match);
		CheckOutPage cop = cp.checkOutPage();
		cop.country("india");
		ConformPage cps = cop.submitorder();
		cps.Conform();
		// String mssg = cps.Conform();
		// Assert.assertTrue(mssg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		List<HashMap<String,String>> data=	getJsonDataReader(System.getProperty("user.dir")+"//src//test//java//Seleniumframework//Properties.json");
		return new Object[][] { {data.get(0)},  {data.get(1)} };
				
		
	}
}
   