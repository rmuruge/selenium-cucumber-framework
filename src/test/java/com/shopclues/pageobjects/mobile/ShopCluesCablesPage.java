package com.shopclues.pageobjects.mobile;

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


public class ShopCluesCablesPage extends Page {

	public ShopCluesCablesPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	static Logger log = Logger.getLogger(ShopCluesCablesPage.class);

	
	@FindBy(how = How.XPATH, using = "//img[contains(@id,'det_img')]")
	@CacheLookup
	public List <WebElement> productImages;
	
	
	public boolean clickProductImage (int index) {
		
		WebElement element;
		boolean ret = false;
		
		if (index < productImages.size()) {
			element = productImages.get(index);
			waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, element );
			element.click();
			switchTab(2);
			ret = true;
		}

		return ret; 
	}

}
