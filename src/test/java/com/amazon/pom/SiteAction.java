package com.amazon.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amazon.utils.AmazonProjectConstants;



public class SiteAction implements AmazonProjectConstants {

	static Logger log = Logger.getLogger(SiteAction.class);
	Actions action;
	private SiteNavigator asn;
	private WebDriver driver;
	
	public SiteAction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		action = new Actions(driver);
	}
	
	public void clickAction() {
		
	}
	
	public void hoverAction(WebElement element) {
		String browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
		log.debug("hover over action : " + element.getText());
		log.debug("Browser is " + browser);
		
		if (CHROME.equals(browser)) {
			action.moveToElement(element).perform();
			
		} else { 
			action.moveToElement(element).perform();
			action.moveToElement(element).perform();
			log.debug("additional hover over action performed for." + browser );
		}
		
		log.debug("hover over action performed.");
	}
	
	public void navigateAction() {
		asn = new SiteNavigator(this.driver);
		
	}

}
