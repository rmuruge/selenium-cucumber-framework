package com.amazon.pom;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;

public class WishListPage extends AmazonBasePage {

	
	@FindBy(how = How.ID, using = "my-lists-tab")
	@CacheLookup
	public WebElement wishList;
	
	static Logger log = Logger.getLogger(WishListPage.class);
	public WishListPage (WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public void validatePage () {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, wishList);
		log.debug("Page Text is " + wishList.getText());
		Assert.assertEquals(wishList.getText(), YOUR_LISTS);
	}

}
