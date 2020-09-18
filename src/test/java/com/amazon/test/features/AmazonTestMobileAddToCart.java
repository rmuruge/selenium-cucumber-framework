package com.amazon.test.features;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.amazon.test.AmazonTestBase;
import com.amazon.test.featurebase.AmazonCheckOut;
import com.amazon.test.featurebase.AmazonSearchProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonTestMobileAddToCart extends AmazonCheckOut {
	
	AmazonSearchProduct searchProduct;

	static Logger log = Logger.getLogger(AmazonTestMobileAddToCart.class);
	public AmazonTestMobileAddToCart() {
		// TODO Auto-generated constructor stub
		this.searchProduct = new AmazonSearchProduct();
	}
	
	@Then ("Application lists results for the searched {string} and validates")
	public void application_lists_results_for_products_and_validates (String product ) throws Exception {
    	log.debug("Product being searched is " + product);
    	searchProduct.searchResults (product);
    	log.debug("Test ends.");
    }
	
//	@Then ("User selects a {string} product from the search results")
	@Then ("User selects a {int} product from the search results")
	public void user_selects_product_from_the_results (int index) throws Exception {
		log.debug("Search Index is " + index);
		//selectProduct(new Integer(searchindex));
		searchProduct.selectProduct(index);
	}

    @Then ("User changes delivery location {int} and validates")
    public void user_changes_delivery_location_and_validates (int pincode) throws Exception {
    	log.debug("pincode is " + pincode);
    	changeDeliveryLocation(new String (""+pincode));
    	log.debug("changed delivery location.");
    }
    
    @Then ("User clicks on add to cart button and validates")
    public void user_clicks_on_add_to_cart_button_and_validates () throws Exception {
    	log.debug("Add to cart");
    	addToCart();
    	log.debug("Added to cart");
    }
}
