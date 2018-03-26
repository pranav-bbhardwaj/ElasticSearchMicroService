package org.testmicro.analytics.processor;

import org.testmicro.analytics.exception.InputValidationException;
import org.testmicro.analytics.exception.SearchException;
import org.testmicro.analytics.exception.StoreException;
import org.testmicro.analytics.rest.service.SearchRequest;
import org.testmicro.analytics.rest.service.SearchResponse;
import org.testmicro.analytics.store.IStore;
import org.testmicro.analytics.store.StoreResponse;

import com.google.inject.Inject;

public class SearchProcessorImpl implements ISearchProcessor{
	
	private IStore store;
	
	@Inject
	void setSearchDataStore(IStore store) {
		this.store = store;
	}

	@Override
	public SearchResponse process(SearchRequest request) throws SearchException {
		
		if(request == null) {
			throw new SearchException("request is unexpectedly null");
		}		
		SearchResponse response = new SearchResponse();
		StoreResponse storeResponse = null;
		
		try {
			// validate the request
			request.validate();
			//process the request
			storeResponse = store.search(request);
			//generate response
			response = successResponse(storeResponse);
			 
		} catch (StoreException e) {
			System.out.println("search request failed : " + e);
			response = errorResponse(storeResponse);
		} catch (InputValidationException e) {
			System.out.println("input validation failed : " + e);
		}
		
		return response;
		
	}

	private SearchResponse errorResponse(StoreResponse storeResponse) {
		SearchResponse response = new SearchResponse();
		
		if(storeResponse != null && storeResponse.getErrorCode() == -1) {
			response.setHttpStatus(400); // request exception
		} else {
			response.setHttpStatus(500); // internal error
		}
		response.setStatusMessage(storeResponse.getStatusMessage());
		return response;
	}

	private SearchResponse successResponse(StoreResponse storeResponse) {
		SearchResponse response = new SearchResponse();

		if(storeResponse.getErrorCode() == 0) {
			response.setHttpStatus(200);
			response.setStatusMessage("query executed successfully");
		} else {
			response.setHttpStatus(500); // unexpected
		}
		
		response.setQueryResults(storeResponse.getResults());
		
		response.setStatusMessage(storeResponse.getStatusMessage());
		return response;
		
	}


}
