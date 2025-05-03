package Nandhini.AbstractComponenets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Nandhini.landingpage.CartCheck;
import Nandhini.landingpage.OrderValidate;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*=\'cart\']")
	WebElement cart;
	
	@FindBy(css="[routerlink*=\'myorders\']")
	WebElement order;
	

	public void elemented(WebElement findBy) {
		  WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));
	 }
	
	public void invisibility(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	}
	
	public void element(By findBy) {
		  WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	 }
	
	public void extract(List<WebElement> findBy) {
		  WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfAllElements(findBy));
	 }
	
	
	
	public CartCheck goTocart() {
		
		cart.click();
		return new CartCheck(driver);
		
	}
	public OrderValidate Order() {
		elemented(order);
		order.click();
		OrderValidate ordervalidate = new OrderValidate(driver);
	    return ordervalidate; 
	}
	
	
}
