package Nandhini.landingpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Nandhini.AbstractComponenets.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    
	}
	
	//WebElement mailid = driver.findElement(By.xpath("//input[@type =\'email\']"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By product = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector(".toast-bottom-right");
	By animate = By.cssSelector(".ng-animating");

	 public List<WebElement> getProductList() {
		 element(product);
		 return products;
	 }
	 
	 public WebElement getProductByName(String productName) {
		 WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		return prod;
	 }
	 
	 public void addTocart(String productName) {
		WebElement prod = getProductByName(productName);
		 prod.findElement(addToCart).click();
		 element(toast);
		 invisibility(animate);
		 
	 }
	
	 
}
