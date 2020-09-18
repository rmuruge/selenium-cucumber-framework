package com.amazon.pom.category.electronics;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.amazon.pom.AmazonBasePage;

import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;


public class Mobile extends AmazonBasePage {

	
	static Logger log = Logger.getLogger(Mobile.class);
	//nav-signin-tt nav-flyout
	
	
	public Mobile(WebDriver d) {
		super(d);
	}
	
/* methods moved to product search page
	@FindBy(how = How.XPATH, using = "//a[@class='a-link-normal a-text-normal']")
	public List <WebElement> searchResults;
	
	public void clickOnSearchedItem(int index) throws Exception {
		if (searchResults.size() > 0) {
			searchResults.get(index).click();
			switchTab(1);
		} else {
			throw new Exception("Number of Search Results in less than ZERO");
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'a-section')]/span[contains(text(), 'results for')]")
	public WebElement resultsElement;
	
	// a. Validate the total results displayed
	public String getTotalResults () {
		String results = null;
		results = resultsElement.getText();
		return results;
	}
	*/
    // b. Play the mobile video
	
	@FindBy(how = How.XPATH, using ="//div[@id='altImages']//*[contains(@class,'videoThumbnail')]//input[@class='a-button-input']")
	public WebElement videoThumbnailElement;
	
	public void playVideo() throws Exception {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, videoThumbnailElement);
		videoThumbnailElement.click();
		togglePlayPauseVideo();
		
		closeVideoPopUpWindow();
		log.debug("Closed Video window.");
		
	}
	
	//vjs-play-control vjs-control vjs-button vjs-paused
	@FindBy(how = How.XPATH, using ="//button[contains(@class,'vjs-play-control')]")
	public WebElement videoControl;
	public void togglePlayPauseVideo() {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, videoControl);
		videoControl.click();
		log.debug("Toggle Paused.");
		
	}
	@FindBy(how = How.XPATH, using ="//button[contains(@data-action,'a-popover-close')]")
	public WebElement videoCloseXButton;
	
	public void closeVideoPopUpWindow() throws Exception {
		videoCloseXButton.click();
	}
    
	// d. Get the product price
    
    @FindBy(how = How.XPATH, using ="//span[@id='priceblock_ourprice']")
    public WebElement productPrice;
    
    public String getProductPrice() throws Exception {
    	
    	return productPrice.getText();
    	
    }
    
    @FindBy(how = How.XPATH, using = "//div[@class='a-divider a-divider-break a-spacing-top-base']/h5")
    public WebElement h5Text;
    
    public void getH5Text() {
    	log.debug("H5 Text is " + h5Text.getText());
    }
    
    @FindBy(how = How.XPATH, using = "//div[@id='contextualIngressPtLabel_deliveryShortLine']")
    public List <WebElement> selectDeliveryLink;

    @FindBy(how = How.XPATH, using = "//input[@data-action='GLUXPostalInputAction']")
    public WebElement enterPincodeTextBox;
    
   //input[@class='a-button-input']
   //input[@aria-labelledby='GLUXZipUpdate-announce']
    
    
    @FindBy(how = How.XPATH, using = "//input[@class='a-button-input' and @aria-labelledby='GLUXZipUpdate-announce']")
    public WebElement applyButton;
    
    
    // e. Change the delivery location
    public void changeDeliveryLocation (String location) throws Exception {
   
    	if (selectDeliveryLink.size() > 0) {
    		selectDeliveryLink.get(1).click();
    		log.debug("Number of Handles " + driver.getWindowHandles().size());
    		int i = driver.findElements(By.tagName("iframe")).size();
    		while (i > 0 ) {
    			
    			i--;
    			log.debug("+++++IFRAME NAME IS : " + driver.findElements(By.tagName("iframe")).get(i).getText());
    		}
    		log.debug("Number of iFrames " + driver.findElements(By.tagName("iframe")).size());
    	}
    	//waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, selectDeliveryLink);
    	//selectDeliveryLink.click();
    	getH5Text();
    	enterPincodeTextBox.sendKeys(location);
    	applyButton.click();
    	log.debug("Clicked on Apply Button");
    	//clickAddToCart();
    	
    }
    
    // f. Add to cart
    @FindBy(how = How.ID, using = "add-to-cart-button")
//    @CacheLookup
    public WebElement addToCartButton;
    //input[@id='add-to-cart-button']
    public String clickAddToCart() throws Exception {
    	log.debug("Adding to Cart .................." + driver.getTitle());
    	waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, addToCartButton);
    	addToCartButton.click();
    	log.debug("Added to Cart ..................");
    	return getAddToCartStatus();
    }
    // g. Close the Add to Cart window
	public void closeAddtoCartWindow () throws Exception {
	 this.closeCurrentTab();
	}
	

	
	//span[@id='contextualIngressPtLabel']/div[@id='contextualIngressPtLabel_deliveryShortLine']

	@FindBy(how = How.XPATH, using ="//div[@id='contextualIngressPtLabel_deliveryShortLine']")
	
	public List <WebElement> locationSpanText;
	
	public String getCurrentDeliveryLocation() throws Exception {
		log.debug("Location Elements identified " + locationSpanText);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, locationSpanText.get(1));
	 return locationSpanText.get(1).getText();
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='huc-v2-order-row-messages']")
	public WebElement addToCartStatusMsg;
	
	public String getAddToCartStatus () throws Exception {
		log.debug("Getting Cart status..................");
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, addToCartStatusMsg);
		return addToCartStatusMsg.getText();
	}

}
