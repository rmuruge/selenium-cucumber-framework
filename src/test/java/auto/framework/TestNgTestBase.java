package auto.framework;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import ru.stqa.selenium.factory.WebDriverPool;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase extends AbstractTestNGCucumberTests {

  static Logger log = Logger.getLogger(TestNgTestBase.class);
  protected URL gridHubUrl = null;
  protected static String baseUrl;
  protected static SuiteConfiguration config;
  
  protected static WebDriver driver;
  

@Override
  @DataProvider(parallel=true)
  public Object [][] scenarios () {
	  return super.scenarios();
  }
  
  @BeforeSuite
  public void initTestSuite() throws IOException {
    config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    log.debug("Base url is " + baseUrl);
    
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
  }
  
  
  @BeforeTest
  @Parameters({"browserName", "node"})
  
  public void initWebDriver(String browserName, String node) throws IOException {
	Capabilities capabilities;
	log.debug("Browser Name Passed " + browserName);
	log.debug("Node  Name Passed " + node);
	capabilities = config.getCapabilities(browserName);
	log.debug("Broswer in Capabilities  is " + capabilities.getBrowserName());

	
	// Enable this if you want to hit hub directly.
	
	if(node.equals("remote")) {
		gridHubUrl = new URL("http://192.168.1.25:5566/wd/hub");
	
	} else {
		gridHubUrl = new URL("http://192.168.1.247:5566/wd/hub");

	} 
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    driver.manage().window().maximize();
	log.debug("Grid URL is : " + gridHubUrl);

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
  
  @AfterClass
  public void takeScreenShot() throws IOException {
	  File imgFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File writeFile = new File (config.getProperty("screenshot.path")+"screenshot.png");
	  writeFile.getParentFile().mkdir();
	  writeFile.createNewFile();
	  Files.copy(imgFile, writeFile);
  }
  public void closeAllTabsBut(String exceptMain) {
	  Set <String> tabs;
	  Iterator <String> iter;
	  tabs = driver.getWindowHandles();
	  String tab;
	  iter = tabs.iterator();
	  while (iter.hasNext()) {
		  tab = iter.next();
		  if (!exceptMain.equals(tab)) {
			  driver.switchTo().window(tab).close();
		  }
	  }	  
  }
}
