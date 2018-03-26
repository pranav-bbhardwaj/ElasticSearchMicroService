package org.testmicro.analytics.rest.service;

import java.util.Properties;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.testmicro.analytics.store.elasticcache.ElasticCacheStore;
import org.testmicro.injection.guice.ServiceGuice;

import com.google.gson.Gson;


@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.security.*", "javax.management.*","javax.crypto.*", "org.bouncycastle.*", "org.apache.log4j.*", "org.apache.logging.log4j.*", "javax.xml.parsers.*","com.sun.org.apache.xerces.*" })
@PrepareForTest({RestHandler.class, ElasticCacheStore.class})
public class TestRestHandler {

	
	@Test
    public void testSearchHandling() throws Exception{
		RestHandler handler = new RestHandler();
		
		SearchRequest request = new SearchRequest();
		request.setData("BOB");
		request.setField(SupportedFields.PLAN_NAME);
		request.setPageEnd(5);
		request.setPageStart(0);
		Gson gson = new Gson();
		Properties props = new Properties();
		props.put("host", "https://search-search-4672r7sysrdycwklf6ye5df4l4.us-east-2.es.amazonaws.com");
		props.put("index", "index");
		props.put("type", "type1");
		ServiceGuice.init(props);
		
		String inputParams = gson.toJson(request);
		
		Response resp = handler.search(inputParams);
		assert(resp!=null);

	}
}
