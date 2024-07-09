package Framework;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import FrameworkAbstract.Abstract;

public class ConformPage extends Abstract {
	WebDriver driver;

	public  ConformPage(WebDriver driver) {
		
		
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(css=".hero-primary")
	WebElement messg;
		public String Conform() {
			
			return	messg.getText();
		}
			public ConformPage conform() {
			ConformPage cps = new ConformPage(driver);
			return cps;
			}
			
	}
	

