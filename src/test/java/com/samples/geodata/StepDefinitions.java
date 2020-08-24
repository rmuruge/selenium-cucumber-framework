package com.samples.geodata;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;


import auto.framework.TestNgTestBase;
import auto.framework.sample.SampleTestNgTest;

public class StepDefinitions extends SampleTestNgTest{
	static Logger log = Logger.getLogger(StepDefinitions.class);
	
	
	@Given("The user opens the site")
	public void application_should_be_launched() {
		log.debug("Test launch");
		testObserver3Dropdowns();
		
	}

    @When ("The user selects country {string} name")
    public void user_enters_country (String string) {
    	log.debug("Test enter country: " + string);
    	testSelectCountry(string);
    }
    @Then ("The user selects region {string} name")
    public void user_enters_region (String string) {
    	log.debug("Test renter region: " + string);
    	testSelectRegion(string);
    	
    }
    @And ("The user selects city {string} name")
    public void user_enters_city (String string) {
    	log.debug("Test enter city: " + string);
    	testCityName(string);
    	
    }
}
