package com.amazon.test.features;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.amazon.test.AmazonTestBase;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AmazonTestGeneralNavigation extends AmazonTestBase {

	static Logger log = Logger.getLogger(AmazonTestGeneralNavigation.class);
	public AmazonTestGeneralNavigation() {
		// TODO Auto-generated constructor stub
	}
	
	
	
    @When ("User enters incorrect site url  {string}")
    public void user_enters_incorrect_site (String string) throws Exception {
    	log.debug("Opening site " + string);
    	openHomePage(string);
    	log.debug("Test ends.");
    }

    @Then ("Site redirects to the correct site url {string}")
    public void site_redirects_to_correct_url (String url) throws Exception {
    	String message = "success";
    	
    	log.debug("Current URL is : " + getCurrentURL());
    	Assert.assertEquals(getCurrentURL(), url, "failed");
    /*	try {
    		log.debug("Current URL is : " + getCurrentURL());
    		Assert.assertEquals(getCurrentURL(), url, "failed");
    		
    	} catch (AssertionError ae) {
    		message = ae.getMessage();
    		log.debug("Assertion Error is " + message);
    		Assert.fail(message);
    	} */
    //	return message;
    }
    @And ("User searches a product {string}")
    public void user_search_for_product (String product) throws Exception {
    
    	log.debug("Searching for product...");
    	if (FAILED.equals(getCurrentURL())) {
    		Assert.fail();
    	} else {
    		searchProduct(product);
    	}
    }
    
    @And ("User closes browser")
    public void user_closes_browser () throws Exception {
    	closeBrowser();
    }
    
    @Given ("User opens the site url {string}")
    public void user_enters_site_url (String url) throws Exception {
    	log.debug("Opening site " + url);
    	openHomePage(url);
    	log.debug("Test ends.");
    }

    @When ("User hovers over {string}")
    public void user_hovers_over_link (String page) throws Exception {
    	log.debug("user_hovers_over_link " + page);
    	hoverOver(page);
    }
}
