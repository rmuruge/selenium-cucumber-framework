package com.amazon.test;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.Reporter;

import com.amazon.pom.AmazonHomePage;
import com.amazon.pom.LoginPage;
import com.amazon.pom.SiteDropDowns;
import com.amazon.pom.SiteNavigator;
import com.amazon.pom.WishListPage;
import com.amazon.utils.AmazonProjectConstants;
import com.amazon.utils.AmazonTestDataLoader;


import auto.framework.TestNgTestBase;
import auto.framework.pageobjects.Page;
import auto.framework.utils.StringUtils;

public class AmazonTestBase extends TestNgTestBase implements AmazonProjectConstants  {

	static Logger log = Logger.getLogger(AmazonTestBase.class);
	
	private Page currentPageObj;
	private Map <String, String> testParmData;
	private AmazonTestDataLoader atd;
	private AmazonHomePage homepage;
	private SiteDropDowns dropdown;
	private SiteNavigator navigate;
	private WishListPage wishlistPage;
	private LoginPage loginPage;
	
	public AmazonTestBase() {
		  super();
		  initPageObjects();
		  navigate = new SiteNavigator(driver);
		  log.debug("Sample Test NG Test: " + driver);
	  }
	
	public void initPageObjects() {
		// Page Objects
		homepage = PageFactory.initElements(driver, AmazonHomePage.class);
		dropdown = PageFactory.initElements(driver, SiteDropDowns.class);
		wishlistPage = PageFactory.initElements(driver, WishListPage.class);
		loginPage = PageFactory.initElements(driver,LoginPage.class);
		
		// Other Objects
		
	}

	public void initTestData () {
		ITestContext itc = Reporter.getCurrentTestResult().getTestContext();
		ISuite is = itc.getSuite();
		testParmData = is.getXmlSuite().getAllParameters();
		atd = new AmazonTestDataLoader();
		atd.loadTestDataMap(testParmData);
		
	}
	public String openHomePage () throws Exception {
		return this.openHomePage(getBaseUrl());
	}
	public String openHomePage(String url) throws Exception {
		//setBaseUrl(url);
		getDriver().get(url);
		log.debug("Redirected URL is " + getDriver().getCurrentUrl());
		return getDriver().getCurrentUrl();
	}
	
	public String getCurrentURL () throws Exception {
		return getDriver().getCurrentUrl();
		
	}
	
	public void searchProduct (String searchString) throws Exception {
		homepage.searchForProduct(searchString);
	}
	
	public void hoverOver (String page) throws Exception {
		if(ACCOUNTS_AND_LISTS.equals(page)) {
			dropdown.hoverOverAccountListDropdown();
		}
	}
	
	public void pageAction (String actionAndPage) throws Exception {
		String [] actions = StringUtils.parseString(actionAndPage, GREATERTHAN, true);
		String action = actions [0];
		String page = actions [1];
		this.pageAction(action, page);
		/*
		 * if (CLICK.equals(actions[0])) { if(CREATE_WISHLIST.equals(actions[1])) {
		 * dropdown.clickWishlist(); } }
		 */
	}
	
	public void pageAction (String action, String page) throws Exception {
		if (CLICK.equals(action)) {
			if(CREATE_WISHLIST.equals(page)) {
				dropdown.clickWishlist();
			} else if (SIGNIN.equals(page)) {
				dropdown.clickOnSignIn();
			} else {
				Assert.fail("Invalid Page");
			}
		}
	}
	public void validatePage (String page) throws Exception {
		
		if (YOUR_LISTS.equals(page)) {
			wishlistPage.validatePage();
		} else {
			log.debug("Invalid Page");
			Assert.fail("Invalid page : " + page);
		}
		
	}
	
	public void enterEmail (String email) throws Exception {
		loginPage.enterEmail (email, true);
		
	}
	
	public void enterPassword (String password) throws Exception {
		loginPage.enterPassword(password, true);
	}
	
	public void confirmLogin (String firstname) throws Exception {
		Assert.assertEquals(homepage.validateLogin(firstname), true);
	}
	
	public void isLoginError (String message ) throws Exception {
		Assert.assertEquals(loginPage.getAuthErrorAlert(), message);
	}
	
	public void signOut () throws Exception {
		dropdown.hoverOverAccountListDropdown();
		log.debug("before signout");
		dropdown.clickSignOut();
	}
}
