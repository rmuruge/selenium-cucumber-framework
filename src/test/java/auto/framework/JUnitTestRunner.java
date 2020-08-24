package auto.framework;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/samples",
		glue = {"com.samples.geodata"},
		//plugin = {"pretty","html:target/cucumber","json:target/cucumber.json"},
		tags = "@smoke0,@smoke1"
		)
public class JUnitTestRunner {

	public JUnitTestRunner() {
		// TODO Auto-generated constructor stub
	}

		static Logger log = Logger.getLogger(JUnitTestRunner.class);
		
		@BeforeClass
		public static void initialize() throws Exception {
			
		}
		
		@AfterClass
		public static void teadDown() throws Exception {
			
		}
		

}
