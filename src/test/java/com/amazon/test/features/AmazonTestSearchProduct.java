package com.amazon.test.features;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.amazon.test.AmazonTestBase;
import com.amazon.test.featurebase.AmazonSearchProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonTestSearchProduct extends AmazonSearchProduct {

	static Logger log = Logger.getLogger(AmazonTestSearchProduct.class);

	public AmazonTestSearchProduct() {
		// TODO Auto-generated constructor stub
	}

	

   
    @And ("User performs action {string} on {string}")
    // @And ("User performs action {string}")
    public void user_performs_action (String actionon, String page) throws Exception {
    	log.debug("User perform action " + actionon);
    	//pageAction(action, page);
    	pageAction(actionon);

    }
    
    @And ("User performs search action {string}")
    public void user_performs_search_action (String action) throws Exception {
    
    	log.debug("Searching for product...");
    	if (FAILED.equals(getCurrentURL())) {
    		Assert.fail();
    	} else {
    		searchProduct(action);
    	}
    	

    }
    
    @Then ("Verify navigation to {string} is successful")
    public void verify_navigation_is_successful (String page) throws Exception {
    	validatePage(page);
    }
    
    @Then ("User sees error message {string}")
    public void user_sees_login_error (String message) throws Exception {
    	isLoginError(message);
    }

    @And ("User enters email {string} and clicks on Continue")
    public void user_enters_email_clicks (String email) throws Exception {
    	//Button is not required.
    	enterEmail(email);
    }
    
    @And ("User enters password {string} and clicks on 'Login' button")
    public void user_enters_password_clicks (String password) throws Exception {
    	enterPassword(password);
    }
    
    @And ("User enters bad password {string} and clicks on 'Login' button")
    public void user_enters_bad_password_clicks (String password) throws Exception {
    	enterPassword(password);
    }
    
    @Then ("User sees greeting message Hi {string} on the top navigation") 
    public void user_sees_greetings_message (String firstname) throws Exception {
    	confirmLogin(firstname);
    	signOut();
    }
}
