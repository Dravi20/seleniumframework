package FrameworkAbstract;

import java.time.Duration;

import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Cartpage;
import Framework.OrderPage;

public class Abstract {
private static final OrderPage OrderPage = null;

WebDriver driver;
	public Abstract(WebDriver driver) {
	this.driver =driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartpage;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement order;
	
	
	public Cartpage addToCartPage() {
		cartpage.click();
		Cartpage cp = new Cartpage(driver);
		return cp;
	}
	public void waitForElement(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElements(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		   wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	public void waitForInvisibility(WebElement ele) {
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		   wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public OrderPage ordertest() {
		OrderPage op1 = new OrderPage(driver);
		 order.click();
		return  op1;
	}
}

