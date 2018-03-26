package org.testmicro.analytics.rest.service;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


@JsonSerialize(include = Inclusion.NON_NULL)
public class SearchResponse {
	
	@JsonIgnore
	private transient Integer httpStatus;
	
	private String statusMessage;
							
	private String queryResults;

	@JsonIgnore
	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getQueryResults() {
		return queryResults;
	}

	public void setQueryResults(String queryResults) {
		this.queryResults = queryResults;
	}
		
}
