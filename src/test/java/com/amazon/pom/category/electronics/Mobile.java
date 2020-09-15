package com.amazon.pom.category.electronics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.pom.AmazonBasePage;

import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;


public class Mobile extends AmazonBasePage {

	//nav-signin-tt nav-flyout
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'a-section')]/span[contains(text(), 'results for')]")
	public WebElement resultsElement;
	
	
	public Mobile(WebDriver d) {
		super(d);
	}
	
	// a. Validate the total results displayed
	public String getTotalResults () {
		String results = null;
		results = resultsElement.getText();
		return results;
	}
	
    // b. Play the mobile video
	
	@FindBy(how = How.XPATH, using ="//div[@id='altImages']//*[contains(@class,'videoThumbnail')]//input[@class='a-button-input']")
	public WebElement videoThumbnailElement;
	
	public void playVideo() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, videoThumbnailElement);
		videoThumbnailElement.click();
		
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
    	
    	if ("5start".equals(noStars)) {
    		
    		fiveStartLink.click();
    		
    	} else if ("4start".equals(noStars)) {
    		fourStartLink.click();
    	} else if ("3start".equals(noStars)) {
    		threeStartLink.click();
    	}else if ("2start".equals(noStars)) {
    		twoStartLink.click();
    	}else if ("1start".equals(noStars)) {
    		oneStartLink.click();
    	}
    	

    }
    
	@FindBy(how = How.XPATH, using ="//span[@id='reviews-filter-info-segment']")
	public WebElement filteredReview;
    
    public String getFilteredRating () throws Exception {
    	
    	return filteredReview.getText();
    }
	// d. Get the product price
    
    @FindBy(how = How.XPATH, using ="//span[@id='priceblock_ourprice']")
    public WebElement productPrice;
    
    public String getProductPrice() throws Exception {
    	
    	return productPrice.getText();
    	
    }
    
    @FindBy(how = How.XPATH, using = "//div[@id='contextualIngressPtLabel_deliveryShortLine']")
    public WebElement selectDeliveryLink;

    @FindBy(how = How.XPATH, using = "//input[@data-action='GLUXPostalInputAction']")
    public WebElement enterPincodeTextBox;
    
   //input[@class='a-button-input']
   //input[@aria-labelledby='GLUXZipUpdate-announce']
    
    
    @FindBy(how = How.XPATH, using = "//input[@class='a-button-input' and @aria-labelledby='GLUXZipUpdate-announce']")
    public WebElement applyButton;
    
    
    // e. Change the delivery location
    public void changeDeliveryLocation (String location) throws Exception {
    	selectDeliveryLink.click();
    	enterPincodeTextBox.sendKeys(location);
    	enterPincodeTextBox.click();
    	
    }
    
    // f. Add to cart
    @FindBy(how = How.ID, using = "add-to-cart-button")
    public WebElement addToCartButton;
    //input[@id='add-to-cart-button']
    public String clickAddToCart() throws Exception {
    	addToCartButton.click();
    	return getAddToCartStatus();
    }
    // g. Close the Add to Cart window
	public void closeAddtoCartWindow () throws Exception {
	 this.closeCurrentTab();
	}
	
	public void closePopUpWindow() throws Exception {
		
	}
	

	@FindBy(how = How.XPATH, using ="//div[@id='contextualIngressPtLabel_deliveryShortLine']")
	public WebElement locationSpanText;
	
	public String getCurrentDeliveryLocation() throws Exception {
	 return locationSpanText.getText();
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='huc-v2-order-row-messages']")
	public WebElement addToCartStatusMsg;
	
	public String getAddToCartStatus () throws Exception {
		
		return addToCartStatusMsg.getText();
	}

}
