package org.testmicro.analytics.store.elasticcache;

import java.io.IOException;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

import org.testmicro.analytics.exception.StoreException;
import org.testmicro.analytics.rest.service.SearchRequest;
import org.testmicro.analytics.store.IStore;
import org.testmicro.analytics.store.StoreResponse;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ElasticCacheStore implements IStore{
	
	private static Gson gson;
	private static JestClientFactory factory;

	@Inject
    @Named("host")
	private String host;//= "https://search-search-4672r7sysrdycwklf6ye5df4l4.us-east-2.es.amazonaws.com";

	
	@Inject
    @Named("index")
	private String index;//= "tester";

	
	@Inject
    @Named("type")
	private String type;//= "type1";
	
	public ElasticCacheStore() {
		

		 gson = new Gson();
	}

	@Override
	public StoreResponse search(SearchRequest request) throws StoreException {
		//create the payload
		if(request ==null) {
			throw new StoreException("request is null.");
		}

		                        
		 String query = queryBuilder(request);
		 Search search = new Search.Builder(query)
         .addIndex(index)
         .addType(type)
         .build();
		 JestClient client = getJestFactory().getObject();
		 SearchResult result = null;
		 try {
			result = client.execute(search);
		} catch (IOException e) {
			System.out.println(" error:" + e);
			throw new StoreException(e);
		}
		 
		 StoreResponse response = processSearchResponse(result);
		return response;
		
	}
	
	private StoreResponse processSearchResponse(SearchResult result) throws StoreException {
		if(result == null) {
			throw new StoreException("response is null.");
		}
		StoreResponse response = new StoreResponse();
		
		if(result.isSucceeded() == false || result.getResponseCode() != 200) {
			
			response.setStatusMessage(result.getErrorMessage()); //consider massaging this errormsg
			throw new StoreException("search failed");
		}
		
		response.setResults(result.getJsonString()); // TODO : massage this response
		
		return response;
		
	}

	private String queryBuilder(SearchRequest request) {

		String[] fields = new String[1];
		fields[0] = request.getField().getFieldName();
		ElasticQueryString queryString = new ElasticQueryString()
											.withQuery(request.getData())
											.withFields(fields);
		
		ElasticSearchQuery query = new ElasticSearchQuery().withElasticQueryString(queryString);
		
		ElasticCacheRequest cacheRequest = new ElasticCacheRequest()
												.withFrom(request.getPageStart())
												.withSize(request.getPageEnd() - request.getPageStart())
												.withQuery(query);
				
		String result = gson.toJson(cacheRequest);
		return result;
	}
	
	//TODO : move to an init() api
	private JestClientFactory getJestFactory() {
		if(factory == null) {
		  synchronized(this) {
			  if(factory == null) {
				 // Construct a new Jest client according to configuration via factory
				 factory = new JestClientFactory();
				 factory.setHttpClientConfig(new HttpClientConfig
				                        .Builder(host)
				                        .multiThreaded(true)
							.defaultMaxTotalConnectionPerRoute(1)
							// and no more 20 connections in total
							.maxTotalConnection(10)
				                        .build());
			  }
		  }
		}  
		
		return factory;
	}
}
