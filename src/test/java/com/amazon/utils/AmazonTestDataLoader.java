package com.amazon.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import auto.framework.utils.StringUtils;


public class AmazonTestDataLoader implements AmazonProjectConstants {

	
	static Logger log = Logger.getLogger(AmazonTestDataLoader.class);
	private  Map <String, String[]> testScenarioMap = new HashMap <String, String[]>();
	
	public AmazonTestDataLoader() {
		// TODO Auto-generated constructor stub
	}

	public void loadTestDataMap(Map <String, String> testParmData) {
		
		String [] scenarios = StringUtils.parseString(testParmData.get(RUN_SCENARIOS),COMMA_DELIMIT,true);
		String [] navPath;

		for (String scenario: scenarios) {
			String nav = testParmData.get(scenario);
			navPath = StringUtils.parseString(nav, NAV_DELIMIT,true);
			testScenarioMap.put(scenario, navPath);
		}
			
	}

	public Map<String, String[]> getTestScenarioMap() {
		return testScenarioMap;
	}

}
