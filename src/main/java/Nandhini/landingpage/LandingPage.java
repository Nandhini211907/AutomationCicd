package Nandhini.landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nandhini.AbstractComponenets.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement mailid = driver.findElement(By.xpath("//input[@type =\'email\']"));
	@FindBy(id ="userEmail")
	WebElement mailid;
    @FindBy(id ="userPassword")
    WebElement pwd;
    @FindBy(id="login")
    WebElement lgn;
    @FindBy(css="[class*='flyInOut']")
    WebElement Error;
    
    public ProductCatalogue login(String email , String password) {
    	mailid.sendKeys(email);
    	pwd.sendKeys(password);
    	lgn.click();
    	return new ProductCatalogue(driver);
    }
    
    public String error() {
    	  elemented(Error);
          return Error.getText();

    }
    

	public void landingV() {
    	driver.get("https://rahulshettyacademy.com/client/");
    }
    
    
}
