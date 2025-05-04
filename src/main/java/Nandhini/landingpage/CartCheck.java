package Nandhini.landingpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Nandhini.AbstractComponenets.AbstractComponents;

public class CartCheck extends AbstractComponents{
	WebDriver driver;
	
	public CartCheck(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartsection;
	@FindBy(css=".totalRow button")
	WebElement submit;
	@FindBy(css="[placeholder=\"Select Country\"]")
	WebElement Country;
	By result = By.cssSelector(".ta-results");
	@FindBy(css=".ta-results button")
	List<WebElement> results;
	@FindBy(xpath="//button[contains(@class, 'ta-item')][2]")
	WebElement Res;
	@FindBy(css=".action__submit")
	WebElement Action;
	By tnx = By.cssSelector(".hero-primary");
	@FindBy(css=".hero-primary")
	WebElement Thanks;
	@FindBy(css=".em-spacer-1 label[class='ng-star-inserted']")
	WebElement how;
	
	
public Boolean matching(String name) {
	extract(cartsection);
	Boolean match = cartsection.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
	return match;
}

public void checkout() {
 submit.click();
}

public void country(String countries) {
	 Country.sendKeys(countries);
	 element(result);
	 Res.click();
	 }
public String place() {
	  Action.click();
	  element(tnx);
	 String message =  Thanks.getText();
	 System.out.println(how.getText());
	 return message;
	
	  
	   
}

}
