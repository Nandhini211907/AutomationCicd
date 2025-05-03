package Nandhini.landingpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GotoCart {
	WebDriver driver;
	
	public CartCheck GotoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		return new CartCheck(driver);
	}
	@FindBy(css="[routerlink*=\\'cart\\']")
	WebElement cart;
	
public void ClickCart() {
	cart.click();
}

}
