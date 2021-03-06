package com.shopclues.pageobjects.homekitchen;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import auto.framework.pageobjects.Page;
import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;


public class ShopCluesHomeFurnishingCurtains extends Page {

	public ShopCluesHomeFurnishingCurtains(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	static Logger log = Logger.getLogger(ShopCluesHomeFurnishingCurtains.class);

	
	@FindBy(how = How.XPATH, using = "//img[contains(@id,'det_img')]")
	public List <WebElement> productImages;
	
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'prod_name')]")
	public List <WebElement> productNames;
	
	public boolean clickProductImage (int index) {
		
		WebElement element;
		boolean ret = false;
		
		if (index < productImages.size()) {
			element = productImages.get(index);
			waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, element );
			element.click();
			ret = true;
		}

		return ret; 
	}
	
	public String getProductName (int index) {
		String name = "";
		log.debug("xxxx " + productNames.size());
		switchTab(2);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, productNames.get(index) );
		log.debug("xxxx2");
		if (index < productNames.size()) {
			log.debug("xxxx2.5");
			name = productNames.get(index).getText();
			log.debug("xxxx3");
		}
		return name;
	}
}
