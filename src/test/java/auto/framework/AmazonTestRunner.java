package auto.framework;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = "features/amazon",
		glue = {"com.amazon.test"},
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
//		tags = "@amazon and not @amz-test3 and not @amz-test4",
		tags = "@amazon",
		monochrome = true
		)
@Listeners({auto.framework.listener.ExecutionListner.class})
public class AmazonTestRunner extends TestNgTestBase {

	static Logger log = Logger.getLogger(AmazonTestRunner.class);

	public AmazonTestRunner() {
		// TODO Auto-generated constructor stub
		log.debug("constructor called");
	}

}
