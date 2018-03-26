package org.testmicro.analytics.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.testmicro.analytics.common.Constants;
import org.testmicro.analytics.exception.SearchException;
import org.testmicro.analytics.processor.ISearchProcessor;
import org.testmicro.injection.guice.ServiceGuice;

import com.google.gson.Gson;


/**
 * Root resource
 */
@Path("/v1/search")
public class RestHandler {
	

	private static Gson gson = new Gson();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	@POST
	@Consumes({ Constants.CONTENT_TYPE })
	@Produces({ Constants.CONTENT_TYPE })
	public Response search(String inputParams) {
		SearchResponse response = null;
		SearchRequest request = null;
		Response restResponse = null;
		try{ 
			request = parseInputParams(inputParams);
			
			response = process(request);
			
			if(response != null && response.getHttpStatus() == 200) {
				restResponse = successResp(response);
			} else {
				restResponse = failureResp(response);
			}
		} catch (Exception e) {
			// log the error and return 
			System.out.println(" error " + e);
			restResponse = failureResp(response);
		}finally {
			// log some audit trail etc.
		}
		
		return restResponse;
	}

	private SearchResponse process(SearchRequest request) throws SearchException {
		ISearchProcessor processor = ServiceGuice.getInjector().getInstance(ISearchProcessor.class);
		SearchResponse response = processor.process(request);
		return response;
	}


	private SearchRequest parseInputParams(String inputParams) {
		SearchRequest request = gson.fromJson(inputParams, SearchRequest.class);
		return request;
	}
	
	private Response failureResp(SearchResponse response) {
		if(response != null) {
			return Response.status(response.getHttpStatus())
					.entity(response).build();
		} else {
			response = new SearchResponse();
			response.setStatusMessage("internal server error");
			return Response.status(500)
					.entity(response).build();  // something went wrong
		}
	}
	
	private Response successResp(SearchResponse response) {
		return Response.ok(response).build();
	}
}
