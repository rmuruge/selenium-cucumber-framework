package com.amazon.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;

public class SiteDropDowns extends AmazonBasePage {

	static Logger log = Logger.getLogger(SiteDropDowns.class);
	public SiteAction sAction;
	
	//nav-signin-tt nav-flyout
	@FindBy(how = How.XPATH, using = "//div[@class='nav-signin-tt nav-flyout']")
	public WebElement flyOutSignIn;
	
	@FindBy(how = How.XPATH, using = "//a[@id='nav-link-accountList']")
	//@CacheLookup
	public WebElement accountListDropdown;
	
	@FindBy(how = How.XPATH, using = "//div[@id='nav-flyout-ya-signin']/a[@class='nav-action-button']")
	//@CacheLookup
	public WebElement signinButton;	
	
	@FindBy(how = How.XPATH, using = "//div[@id='nav-al-wishlist']/a[@class='nav-link nav-item']/span[text()='Create a Wish List']")
	public WebElement wishlist;
	
	@FindBy(how = How.ID, using = "nav-item-signout")
	//@CacheLookup
	public WebElement signoutButton;
	
	public SiteDropDowns (WebDriver d) {
		// TODO Auto-generated constructor stub
		super (d);
		sAction = new SiteAction(d);
	}
	
	
	public void hoverOverAccountListDropdown() throws Exception  {
		log.debug("Hover Over Account & List dropdown");
		printDriverInfo(driver);
		//waitForElement (WAITS.EXPLICIT, WAIT_ACTION.VISIBLE,flyOutSignIn );
		sAction.hoverAction(accountListDropdown);
		//sAction.hoverAction(accountListDropdown);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, accountListDropdown);
		//log.debug("Visible ------------------------------");
		//waitForElement (WAITS.EXPLICIT, WAIT_ACTION.DISAPPEARS,flyOutSignIn );
		//log.debug("disappeared ------------------------------");
		//sAction.hoverAction(accountListDropdown);
		//log.debug("hovered..................................");
		// accountListDropdown
	}
	public void clickWishlist() throws Exception  {
		log.debug("clicking wishlist");
		printDriverInfo(driver);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, wishlist);
		wishlist.click();
	}
	
	public void clickOnSignIn() throws Exception {
		printDriverInfo(driver);
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.BUTTON, signinButton);
		
		signinButton.click();
	}
	
	public void clickSignOut () throws Exception {
		signoutButton.click();
	}

	
}
