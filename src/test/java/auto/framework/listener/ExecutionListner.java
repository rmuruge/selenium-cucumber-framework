package auto.framework.listener;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import auto.framework.report.ResultSender;
import auto.framework.report.TestStatus;

import io.cucumber.junit.Cucumber;
import io.cucumber.messages.Messages.GherkinDocument.Feature.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

public class ExecutionListner implements ITestListener {

	static Logger log = Logger.getLogger(ExecutionListner.class);
	public ExecutionListner() {
		// TODO Auto-generated constructor stub
	}

    private TestStatus testStatus;

    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"PASS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        this.sendStatus(iTestResult,"FAIL");
    }

    public void onTestSkipped(ITestResult iTestResult) {
    	
        this.sendStatus(iTestResult,"SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //skip
    }

    public void onStart(ITestContext iTestContext) {
        //skip
    }

    public void onFinish(ITestContext iTestContext) {
        //skip
    }

    private void sendStatus(ITestResult iTestResult, String status){
    	log.debug("Sending results: " + iTestResult.toString());
    	log.debug("Sending results for the scenario: " + Scenario.parser());
    	//this.testStatus.setTestRun(iTestResult.getTestContext().);
    	this.testStatus.setTestRun(iTestResult.getTestContext().getName());
        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
        this.testStatus.setStatus(status);
        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
        ResultSender.send(this.testStatus);
    }
}
