package Nandhini.TestDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Nandhini.TestComponents.BaseTest;
import Nandhini.landingpage.CartCheck;
import Nandhini.landingpage.LandingPage;
import Nandhini.landingpage.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionImpl extends BaseTest {
    public LandingPage landingpage;
    public ProductCatalogue prodcat;
    public List<WebElement> products;
    public String message;
    
	@Given("I landed on ecom page")
	public void I_landed_on_ecom() throws IOException {
		landingpage = landing();
	}
@Given("^Logged in with username (.+) and password (.+)$") 
public void logged_in_with_user(String mailid , String password) {
	 prodcat = landingpage.login(mailid, password);
}
@When("^I Add the product (.+) to cart$")
public void Add_the_product(String name) {
    products = prodcat.getProductList();
    prodcat.addTocart(name);
}

@And("^Checkout (.+) and submit order$")
public void Checkoout(String name) {
	CartCheck cartcheck  = prodcat.goTocart();
    Boolean match =  cartcheck.matching(name);
    Assert.assertTrue(match);
    cartcheck.checkout();
    cartcheck.country("india");
    message =  cartcheck.place();
}
@Then("{string} message is displayed on confirmationpage")
public void confirmationpage(String Expectedmessage) {

    Assert.assertTrue(message.equalsIgnoreCase(Expectedmessage));     
     
}


}
