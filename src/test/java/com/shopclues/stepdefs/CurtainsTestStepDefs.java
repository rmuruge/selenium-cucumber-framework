package com.shopclues.stepdefs;

import org.apache.log4j.Logger;


import com.shopclues.CurtainsTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CurtainsTestStepDefs extends CurtainsTest {
	static Logger log = Logger.getLogger(CurtainsTestStepDefs.class);
	public CurtainsTestStepDefs() {
		// TODO Auto-generated constructor stub
	}
	
    @Given("The user opens the site")
	public void user_launchs_the_website() throws Exception {
		log.debug("Begin: The user opens the site");
		testCloseNotification();
		log.debug("End: The user opens the site");
	}
    @When ("The user hover over {string} item")
	public void user_hovers_over_the_menu (String string) throws Exception {
    	testHoverOnMenu(string);
		log.debug("The user hover over "+string +" item.");
		
	}
    @Then ("The user clicks {string} link")
	public void user_clicks_dropdown_link (String string) {
		log.debug("The user clicks " + string + " link.");
		testClickDropdown(string);
		
	}
    @And ("The user selects {string} item")
	public void user_clicks_on_item (String string) {
		log.debug("The user selects " + string + " item.");
		testClickProductImage(string);
		isProductImgDisplayed();
	}
    @And ("The user click {string} button")
	public void user_clicks_on_the_button (String string) {
		log.debug("The user click " + string + "button.");
		testClickButton(string);
		
	}
    @And ("The user for action {string} sees {string} message")
	public void user_sees_message (String string1, String string2) {
		log.debug("The user see " + string1 + " " + string2 + "message.");
		testMessageForAction(string1, string2);
		
	}

}
