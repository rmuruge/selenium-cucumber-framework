package com.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SiteNavigator {

	private WebDriver driver;
	
	public SiteNavigator(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void initPageObjects() {
		// Page Objects
//		homepage = PageFactory.initElements(driver, AmazonHomePage.class);
		
		
		// Other Objects
		
	}
	public void goTo(String link) {
		
	}

}
