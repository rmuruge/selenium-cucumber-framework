package com.amazon.test.features;

import com.amazon.test.featurebase.AmazonReviews;

import io.cucumber.java.en.Then;

public class AmazonTestReviews extends AmazonReviews {

	public AmazonTestReviews() {
		// TODO Auto-generated constructor stub
	}
	
    
    @Then ("User hovers over user reviews and selects {string}")
    public void user_hovers_over_reviews_and_selects_a_rating (String rating)  throws Exception {
    	selectCustomerRating(rating);
    }

}
