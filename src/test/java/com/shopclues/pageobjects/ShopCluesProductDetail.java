package com.shopclues.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import auto.framework.pageobjects.Page;
import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;



public class ShopCluesProductDetail extends Page{

	public ShopCluesProductDetail(WebDriver d) {
		// TODO Auto-generated constructor stub
		super(d);
		
	}
	
	static Logger log = Logger.getLogger(ShopCluesProductDetail.class);

	@FindBy(how = How.XPATH, using = "//span[@value='Black']")
	public WebElement colorOption;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@id,'add_cart')]")
	public WebElement addToCartButton;

	@FindBy(how = How.XPATH, using = "//div[@id='snackbar' and @class='show']")
	public WebElement confirmation;
	
	@FindBy(how = How.XPATH, using = "//li[(@id='thumb_click_0')]/a/img")
	public WebElement firstProductThumbnail;
	
	@FindBy(how=How.XPATH, using = "//div[(@class='zoomContainer')]")
	//@FindBy(how=How.XPATH, using = "//div[(@class='zoomLens')]")
	public WebElement zoomContainer;
	
	public boolean productImgDisplayed () {
		//String attrib = waitForElement(WAITS.EXPLICIT,WAIT_ACTION.VISIBLE,firstProductThumbnail).getAttribute("data-img");
		waitForElement(WAITS.EXPLICIT,WAIT_ACTION.VISIBLE,firstProductThumbnail);
		waitForElement(WAITS.EXPLICIT,WAIT_ACTION.VISIBLE,zoomContainer);
		String attrib = firstProductThumbnail.getTagName();
		boolean iszoomContainerDisplayed = zoomContainer.isDisplayed();
		
		boolean isDisplayed = false;
		log.debug("Image Loc is : " + attrib + " zoom " + iszoomContainerDisplayed);
		if (attrib.contains("img") && iszoomContainerDisplayed ) {
			isDisplayed = true;
		} 
		return isDisplayed;
	}
	public void clickAddToCart () {
		
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, addToCartButton);
		boolean isOption = true;
		String sel;
		try {
			sel = colorOption.getAttribute("class");
			//sel = sel + " selected";
			log.debug("class is " + sel);
			colorOption.click();
			
			//colorOption.click();
			Actions ac = new Actions(driver);
			ac.click(colorOption);
			
		} catch (NoSuchElementException nse) {
			isOption = true;
		}
		log.debug("add to cart is " + addToCartButton.getText());
		if (isOption) addToCartButton.click();

	}
	
	
	public String confirmAddToCart () {
		
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, confirmation);

		log.debug("Message is : " + confirmation.getText());
		return confirmation.getText();

	}

}
