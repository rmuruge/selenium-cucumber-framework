package com.shopclues;

import java.awt.AWTException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.shopclues.pageobjects.ShopCluesHomePage;
import com.shopclues.pageobjects.ShopCluesProductDetail;
import com.shopclues.pageobjects.homekitchen.ShopCluesHomeFurnishingCurtains;
import com.shopclues.utils.ProjectConstants;
import com.shopclues.utils.TestDataLoader;

import auto.framework.TestNgTestBase;






public class CurtainsTest extends TestNgTestBase 
implements ProjectConstants {

	static Logger log = Logger.getLogger(CurtainsTest.class);
	private ShopCluesHomePage homepage;
	private ShopCluesHomeFurnishingCurtains curtainPage;
	private ShopCluesProductDetail detailPage;
	private Map <String, String> testParmData;
	private TestDataLoader td;
	
	public CurtainsTest() {
		  super();
		  initPageObjects();
		  log.debug("Sample Test NG Test: " + driver);
	  }

	 public void initPageObjects() {
		   homepage = PageFactory.initElements(driver, ShopCluesHomePage.class);
		   curtainPage = PageFactory.initElements(driver, ShopCluesHomeFurnishingCurtains.class);
		   detailPage =  PageFactory.initElements(driver, ShopCluesProductDetail.class);	 
	 }
	public void initTestData () {
			ITestContext itc = Reporter.getCurrentTestResult().getTestContext();
			ISuite is = itc.getSuite();
			testParmData = is.getXmlSuite().getAllParameters();
			td = new com.shopclues.utils.TestDataLoader();
			td.loadTestDataMap(testParmData);
			
		}

	public void testCloseNotification() throws Exception {
		driver.get(baseUrl);
		homepage.closeNotification();;		
	}

	public void testHoverOnMenu(String menu) throws AWTException, InterruptedException {
		if (HOME_AND_KITCHEN.equalsIgnoreCase(menu)){
			homepage.hoverHomeKitchenNav1();	
		} else if (MOBILE_AND_ELECTRONICS.equalsIgnoreCase(menu)) {
			homepage.hoverMobileElectronicsNav1();
		} else if (DAILY_ESSENTIALS.equalsIgnoreCase(menu)) {
			homepage.hoverDailyEssentialsNav1();
		} else if (MEN.equalsIgnoreCase(menu)) {
			log.debug("Hover not implemented for " + menu);
		} else if (WOMEN.equalsIgnoreCase(menu)) {
			log.debug("Hover not implemented for " + menu);
		}
	}
	
	public void testClickDropdown(String link) {
		if (CURTAINS.equalsIgnoreCase(link)) {
			homepage.clickCurtainNav2();
		} else if (CABLES.equalsIgnoreCase(link)) {
			homepage.clickCablesNav2();
		} else if (COFFEE_AND_TEA.equalsIgnoreCase(link)) {
			homepage.clickCoffeeTeaNav2();
		}
	}
	
	public void testClickProductImage(String index) {
		Assert.assertEquals(curtainPage.clickProductImage(Integer.parseInt(index.trim())),true);	
	}
	
	public void isProductImgDisplayed() {
		detailPage.switchTab(2);
		Assert.assertEquals(detailPage.productImgDisplayed(),true);	
	}
	

	public void testClickButton (String button) {
		if (ADD_TO_CART.equalsIgnoreCase(button)) {
			detailPage.clickAddToCart();
		}
	}

	public void testMessageForAction (String button, String expectedMessage) {
		if (ADD_TO_CART.equalsIgnoreCase(button)) {
			Assert.assertEquals(detailPage.confirmAddToCart(), expectedMessage);
		}
		
	}

}
