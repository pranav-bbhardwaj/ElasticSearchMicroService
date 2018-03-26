package org.testmicro.analytics.store;


public class StoreResponse {
	
	private String statusMessage;
	
	private int errorCode;

	private String results;

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
}
