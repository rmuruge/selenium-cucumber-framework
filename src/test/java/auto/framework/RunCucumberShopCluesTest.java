package auto.framework;

import org.apache.log4j.Logger;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "features/shopclues",
		glue = {"com.shopclues.stepdefs"},
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
		tags = "@regression"
		)
public class RunCucumberShopCluesTest extends TestNgTestBase {

	static Logger log = Logger.getLogger(RunCucumberShopCluesTest.class);
	public RunCucumberShopCluesTest() {
		// TODO Auto-generated constructor stub
		log.debug("Constructor called");
	}

}
