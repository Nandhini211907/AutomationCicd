package Nandhini.Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Nandhini.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
    @Test
	public void submitOrder() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String name = "ADIDAS ORIGINAL";
		String countries = "India";
	    landingpage.login("nandhini@test.com", "Test@124");
	    Assert.assertEquals("Incorrect email or password.", landingpage.error());
       
     
      

    	
    	}

 
}