package auto.framework;


import io.cucumber.testng.CucumberOptions;

import org.apache.log4j.Logger;



@CucumberOptions(
		features = "features/samples",
		glue = {"com.samples.geodata"},
		plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"},
		tags = "@smoke"
		)
public class RunCucumberTest extends TestNgTestBase {
	static Logger log = Logger.getLogger(RunCucumberTest.class);
	

}
