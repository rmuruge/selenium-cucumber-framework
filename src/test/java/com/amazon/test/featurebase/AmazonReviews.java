package com.amazon.test.featurebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


import com.amazon.pom.detail.CustomerReviewPage;
import com.amazon.test.AmazonTestBase;

public class AmazonReviews extends AmazonTestBase {

	CustomerReviewPage reviewPage;
	static Logger log = Logger.getLogger(AmazonReviews.class);
	public AmazonReviews() {
		// TODO Auto-generated constructor stub
		super();
		initPageObjects();
	}
	public void initPageObjects() {
		super.initPageObjects();
		// Page Objects
		reviewPage = PageFactory.initElements(driver,CustomerReviewPage.class);
		log.debug("Mobile Initialized");
		// Other Objects
	}
	
	public void selectCustomerRating(String noStars) throws Exception {
		reviewPage.selectCustomerReview(noStars);
	}
}
