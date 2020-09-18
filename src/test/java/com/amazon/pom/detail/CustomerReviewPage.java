package com.amazon.pom.detail;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.pom.AmazonBasePage;
import com.amazon.pom.category.electronics.Mobile;

public class CustomerReviewPage extends AmazonBasePage {

	static Logger log = Logger.getLogger(CustomerReviewPage.class);
	public CustomerReviewPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	// c. Select the Avg Customer Review selection
	
	@FindBy(how = How.XPATH, using ="//a[@id='acrCustomerReviewLink']")
	public WebElement custReviewElement;
	
	@FindBy(how = How.XPATH, using ="//a[@class='a-link-normal 5star']")
	public WebElement fiveStartLink;
	@FindBy(how = How.XPATH, using ="//a[@class='a-link-normal 4star']")
	public WebElement fourStartLink;
	@FindBy(how = How.XPATH, using ="//a[@class='a-link-normal 3star']")
	public WebElement threeStartLink;
	@FindBy(how = How.XPATH, using ="//a[@class='a-link-normal 2star']")
	public WebElement twoStartLink;
	@FindBy(how = How.XPATH, using ="//a[@class='a-link-normal 1star']")
	public WebElement oneStartLink;
	

	
    public void selectCustomerReview (String noStars) throws Exception {
    	custReviewElement.click();
    	
    	if ("5 star".equals(noStars)) {
    		
    		fiveStartLink.click();
    		
    	} else if ("4 star".equals(noStars)) {
    		fourStartLink.click();
    	} else if ("3 star".equals(noStars)) {
    		threeStartLink.click();
    	}else if ("2 star".equals(noStars)) {
    		twoStartLink.click();
    	}else if ("1 star".equals(noStars)) {
    		oneStartLink.click();
    	}
    	

    }
    
	@FindBy(how = How.XPATH, using ="//span[@id='reviews-filter-info-segment']")
	public WebElement filteredReview;
    
    public String getFilteredRating () throws Exception {
    	
    	return filteredReview.getText();
    }

}
