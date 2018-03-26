package org.testmicro.analytics.processor;

import java.util.Properties;

import org.junit.Test;
import org.testmicro.analytics.rest.service.SearchRequest;
import org.testmicro.analytics.rest.service.SearchResponse;
import org.testmicro.analytics.rest.service.SupportedFields;
import org.testmicro.injection.guice.ServiceGuice;

public class TestSearchProcessor {

	
	@Test
    public void testSearchProcessor() throws Exception{
		
		SearchRequest request = new SearchRequest();
		request.setPageStart(0);
		request.setPageEnd(5);
		
		request.setData("BOB");
		request.setField(SupportedFields.PLAN_NAME);
		
		Properties props = new Properties();
		props.put("host", "https://search-search-4672r7sysrdycwklf6ye5df4l4.us-east-2.es.amazonaws.com");
		props.put("index", "tester");
		props.put("type", "type1");
		ServiceGuice.init(props);
		
		ISearchProcessor processor = ServiceGuice.getInjector().getInstance(ISearchProcessor.class);
		
		SearchResponse response = processor.process(request);
		
		assert(response != null);
	
    }
}
