package com.amazon.test.featurebase;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


import com.amazon.pom.category.electronics.Mobile;
import com.amazon.test.AmazonTestBase;

public class AmazonPlayVideo extends AmazonTestBase {
	static Logger log = Logger.getLogger(AmazonPlayVideo.class);
	
	private Mobile mobilePage;
	
	public AmazonPlayVideo() {
		// TODO Auto-generated constructor stub
		super();
		initPageObjects();
	}
	
	public void initPageObjects() {
		super.initPageObjects();
		// Page Objects
		mobilePage = PageFactory.initElements(driver,Mobile.class);
		log.debug("Mobile Initialized");
		// Other Objects
	}
	
	public void playVideoDemo() throws Exception {
		mobilePage.playVideo();
	}

}
