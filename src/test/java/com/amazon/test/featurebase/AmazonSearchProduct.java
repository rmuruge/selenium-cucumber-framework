package com.amazon.test.featurebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


import com.amazon.pom.ProductSearchPage;

import com.amazon.test.AmazonTestBase;

public class AmazonSearchProduct extends AmazonTestBase {

	
	static Logger log = Logger.getLogger(AmazonSearchProduct.class);
	ProductSearchPage searchProduct;
	public AmazonSearchProduct() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	public void initPageObjects() {
		super.initPageObjects();
		searchProduct = PageFactory.initElements(driver,ProductSearchPage.class);
		log.debug("ProductSearchPage Initialized");
		// Other Objects
		
	}
	public void searchResults (String product) throws Exception {
		String results;		
		results = searchProduct.getTotalResults();
		log.debug("Results is " + results);
		
	}
	
	public void selectProduct (int index) throws Exception {
		log.debug("selecting product ...");
		searchProduct.clickOnSearchedItem(index);
		log.debug("selected product.");
	}
}
