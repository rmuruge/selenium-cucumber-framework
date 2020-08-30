package com.amazon.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SiteAction {

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
		log.debug("hover over action : " + element.getText());
		
		action.moveToElement(element).perform();
	}
	
	public void navigateAction() {
		asn = new SiteNavigator(this.driver);
		
	}

}
