package auto.framework.report;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestStatus {
	
	static Logger log = Logger.getLogger(TestStatus.class);

	public TestStatus() {
		// TODO Auto-generated constructor stub
	}
	
	@JsonProperty("testClass")
	private String testClass;
	
    @JsonProperty("description")
    private String description;

    @JsonProperty("status")
    private String status;

    @JsonProperty("executionTime")
    private String executionTime;
    
    @JsonProperty("duration")
    private String duration;
    
    @JsonProperty("location")  
    private String location;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("testRun")
    private String testRun;
    
    public void setTestRun (String testRun) {
    	this.testRun = testRun;
    }
    
    public void setName (String name) {
    	this.name = name;
    }
    
    public void setLocation (String location) {
    	this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExecutionDate(String executionTime) {
        this.executionTime = executionTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setDuration (String duration) {
    	this.duration = duration;
    }
    
    public void setTestClass (String testClass) {
    	
    }

}
