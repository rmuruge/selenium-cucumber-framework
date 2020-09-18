package auto.framework.report;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class ResultSender {

	public ResultSender() {
		// TODO Auto-generated constructor stub
	}

	static Logger log = Logger.getLogger(ResultSender.class);
	
    private static final ObjectMapper OM = new ObjectMapper();
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static String ELASTICSEARCH_URL = "http://localhost:9200/app/suite"; 
    
    public static void send(final TestStatus testStatus){
        try {
            Unirest.post(ELASTICSEARCH_URL)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(OM.writeValueAsString(testStatus)).asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   public static void setElasticSearchUrl(String url) {
	   ELASTICSEARCH_URL = url;
   }

}
