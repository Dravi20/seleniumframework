package Framework;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FrameworkAbstract.Abstract;
import dev.failsafe.internal.util.Assert;

public class OrderPage extends Abstract {
WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//td[contains(text(),'ADIDAS ORIGINAL')])[1]")
	WebElement check;
	
	
	

	public OrderPage goToOrderPage() {
		//  check.stream().anyMatch(p->p.getText().equalsIgnoreCase(productname));
		OrderPage op = new OrderPage(driver);
		check.getText();
		
		return  op;
	}
}

