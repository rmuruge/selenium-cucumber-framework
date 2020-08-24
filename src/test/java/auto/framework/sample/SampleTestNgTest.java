package auto.framework.sample;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import auto.framework.TestNgTestBase;
import auto.framework.pageobjects.HomePage;





public class SampleTestNgTest extends TestNgTestBase {
	static Logger log = Logger.getLogger(SampleTestNgTest.class);
	private HomePage homepage;
	
  public SampleTestNgTest() {
	  super();
	  initPageObjects();
	  log.debug("Sample Test NG Test: " + driver);
  }
  
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }


  public void testObserver3Dropdowns() {

    driver.get(baseUrl);

    By by = By.xpath("//label[contains(@for, 'countryCode')]");
    Assert.assertTrue("Country Name".equals(homepage.observeDropdowns(by)));
    
    by = By.xpath("//label[contains(@for, 'regionName')]");
    Assert.assertTrue("Region Name".equals(homepage.observeDropdowns(by)));
    
    by = By.xpath("//label[contains(@for, 'cityName')]");
    Assert.assertTrue("City Name".equals(homepage.observeDropdowns(by)));
  }
  

  public void testSelectCountry(String country) {
  
	  By by = By.id("countryCode");
	  Select coDrop = new Select (driver.findElement(by));		 
	  //coDrop.selectByValue("AU");
	  coDrop.selectByValue(country);
	  Assert.assertEquals(coDrop.getFirstSelectedOption().getText().trim(),"Australia");
  }

 
  public void testSelectRegion(String region ) {
  
	  By by = By.id("regionName");
	  Select regDrop = new Select (driver.findElement(by));
	  List <WebElement> options =  regDrop.getOptions();
	  if (options.size()>1) {
		 regDrop.selectByVisibleText(region);
		 //regDrop.selectByVisibleText("Western Australia");
	  }
	  Assert.assertEquals(regDrop.getFirstSelectedOption().getText().trim(),"Western Australia");
  }
  
  

  public void testCityName(String city) {
	  
	  By byCity = By.id("cityName");
	  Select cityDrop = new Select (driver.findElement(byCity));
	  List <WebElement> options =  cityDrop.getOptions();
	  if (options.size()>1) {
		 //cityDrop.selectByVisibleText("Perth");
		 cityDrop.selectByVisibleText(city);
	  }
			 
	  Assert.assertEquals(cityDrop.getFirstSelectedOption().getText().trim(),"Perth");
  }
}
