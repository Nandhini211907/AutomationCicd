package Nandhini.Tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Nandhini.TestComponents.BaseTest;
import Nandhini.landingpage.CartCheck;
import Nandhini.landingpage.OrderValidate;
import Nandhini.landingpage.ProductCatalogue;

public class Alone extends BaseTest {
	//String name = "ADIDAS ORIGINAL";
    @Test(dataProvider="getdata",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
    	
		String countries = "India";
		ProductCatalogue prodcat = landingpage.login(input.get("email"), input.get("password"));
		List<WebElement> products = prodcat.getProductList();
        prodcat.addTocart(input.get("name"));
        CartCheck cartcheck  = prodcat.goTocart();
        Boolean match =  cartcheck.matching(input.get("name"));
        Assert.assertTrue(match);
        cartcheck.checkout();
        cartcheck.country(countries);
       String message =  cartcheck.place();
       System.out.println(message);
       Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));     
        
    	}
    
    @Test(dependsOnMethods = {"submitOrder"})
    public void ordercheck(String email,String password, String name )
    {
    	
    	ProductCatalogue prodcat = landingpage.login(email,password);
    	OrderValidate ordervalidate = prodcat.Order();
    	Assert.assertTrue(ordervalidate.validate(name));
    			}
  

   
   @DataProvider
   public Object[][] getdata() throws IOException {
	   
	   List<HashMap<String, String>> data = getjsondata(System.getProperty("user.dir")+"\\src\\test\\java\\Nandhini\\data\\PurchaseOrder.json");
	   return new Object[][] { {data.get(0)},{data.get(1)}  };
 
}
}