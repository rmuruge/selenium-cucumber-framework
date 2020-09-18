package com.amazon.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductSearchPage extends AmazonBasePage {

	static Logger log = Logger.getLogger(ProductSearchPage.class);
	public ProductSearchPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='a-link-normal a-text-normal']")
	public List <WebElement> searchResults;
	
	public void clickOnSearchedItem(int index) throws Exception {
		if (searchResults.size() > 0) {
			searchResults.get(index).click();
			switchTab(driver.getWindowHandles().size()-1);
		} else {
			throw new Exception("Number of Search Results in less than ZERO");
		}
		
	}
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'a-section')]/span[contains(text(), 'results for')]")
	public WebElement resultsElement;
	
	// a. Validate the total results displayed
	public String getTotalResults () {
		String results = null;
		results = resultsElement.getText();
		return results;
	}


}
