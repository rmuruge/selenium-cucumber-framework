package com.amazon.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import auto.framework.utils.Enumerations.WAITS;
import auto.framework.utils.Enumerations.WAIT_ACTION;

public class LoginPage extends AmazonBasePage {

	static Logger log = Logger.getLogger(LoginPage.class);
	
	//screen 1 enter email
	//input[@id='ap_email']
	@FindBy(how = How.ID, using = "ap_email")
	@CacheLookup
	public WebElement emailTextbox;
	
	//input[@id='continue']
	@FindBy(how = How.ID, using = "continue")
	@CacheLookup
	public WebElement continueButton;
	
	//screen 2 enter password
	//input[@id='ap_password']
	
	@FindBy(how = How.ID, using = "ap_password")
	@CacheLookup
	public WebElement passwordTextbox;
	
	//input[@id='signInSubmit']
	@FindBy(how = How.ID, using = "signInSubmit")
	@CacheLookup
	public WebElement submitButton;
	
	//screen 3 error if incorrect password
	//h4[@class='a-alert-heading']
	//div[@id='auth-error-message-box']//h4[@class='a-alert-heading']
	@FindBy(how = How.XPATH, using = "//div[@id='auth-error-message-box']//h4[@class='a-alert-heading']")
	public WebElement alertHeading;
	//
	//div[@id='auth-error-message-box']//span[@class='a-list-item']
	@FindBy(how = How.XPATH, using = "//div[@id='auth-error-message-box']//span[@class='a-list-item']")
	public WebElement errorMessagDiv;

	
	public LoginPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
	}
	
	public void enterEmail(String email, boolean isclick) throws Exception {
		this.enterEmail(email);
		if(isclick) {
			this.clickContinue();
		}
		
	}

	public void enterEmail(String email) throws Exception {
		emailTextbox.sendKeys(email);
		
	}
	
	public void clickContinue () throws Exception {
		continueButton.click();
	}
	
	public void enterPassword(String email) throws Exception {
		passwordTextbox.sendKeys(email);
		
	}
	
	public void enterPassword(String password, boolean isclick) throws Exception {
		this.enterPassword(password);
		if(isclick) {
			clickSignIn();
		}
		
	}
	
	public void clickSignIn () throws Exception {
		submitButton.click();
	}
	
	public String  getAuthErrorHeading () throws Exception {
		return alertHeading.getText();
	}
	
	public String  getAuthErrorAlert () throws Exception {
		waitForElement(WAITS.EXPLICIT, WAIT_ACTION.VISIBLE, errorMessagDiv);
		return errorMessagDiv.getText();
	}
	
}
