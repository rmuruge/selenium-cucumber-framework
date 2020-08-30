package com.amazon.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;



public class AmazonHomePage extends AmazonBasePage {

	static Logger log = Logger.getLogger(AmazonHomePage.class);
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	@CacheLookup
	public WebElement productSearchBox;

	@FindBy(how = How.ID, using = "nav-link-accountList")
	@CacheLookup
	public WebElement accountListLink;
	
	//div[@id='nav-xshop']/a[2]
	
	@FindBy(how = How.XPATH, using = "//a[@class='nav-a  ']")
	@CacheLookup
	public WebElement [] navATabs;
	
	//container that has greeting for user logged in "Hello, Rajkumar"
	@FindBy(how = How.XPATH, using = "//div[@class='nav-line-1-container']/span[@class='nav-line-1']")
	public List <WebElement>  navLineContainers;
	
	
	//@FindBy(how = How.XPATH, using = "//span[@id='nav-search-submit-text']")
	@FindBy(how = How.XPATH, using = "//div[@class='nav-search-submit nav-sprite']")
	@CacheLookup
	public WebElement productSearchIcon;
	
	public AmazonHomePage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	public void searchForProduct(String product) throws Exception {
		productSearchBox.sendKeys(product);
		productSearchIcon.click();
		
	}
	
	public boolean validateLogin (String firstname) throws Exception {
		String msg = "";
		boolean hasLoggedIn = false;
		
		WebElement we = null;
		log.debug("Nav Line Containers Lenght " + navLineContainers);
		for (int i=0; i < navLineContainers.size(); i++) {
			msg = navLineContainers.get(i).getText();
			log.debug("message is " + msg);
			
			if (new String(GREETING_MSG +firstname).equals(msg)) {
				we = navLineContainers.get(i);
				hasLoggedIn = true;
				break;
			}
		}
		
		return hasLoggedIn;
	}

}
