package Nandhini.landingpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nandhini.AbstractComponenets.AbstractComponents;

public class OrderValidate extends AbstractComponents {
	WebDriver driver;
	public OrderValidate(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);   
	}

   @FindBy(css="tr td:nth-child(3)")	
   List<WebElement> orderdetails;
   @FindBy(css=".table-hover")
   WebElement rep;
   
	public Boolean validate(String name) {
		elemented(rep);
		Boolean match = orderdetails.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		return match;	
	}
	

}
