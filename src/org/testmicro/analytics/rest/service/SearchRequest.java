package org.testmicro.analytics.rest.service;

import org.testmicro.analytics.exception.InputValidationException;

import com.google.gson.annotations.Expose;

public class SearchRequest {
	
	@Expose
	private String data;
	
	@Expose
	private SupportedFields field;
	
	@Expose
	private int pageStart;
	
	@Expose
	private int pageEnd;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public SupportedFields getField() {
		return field;
	}

	public void setField(SupportedFields field) {
		this.field = field;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	
	public void validate() throws InputValidationException {
		if(this.data == null || this.data.isEmpty()) {
			throw new InputValidationException("input data is not valid");
		}
		
		if(this.field == null) {
			throw new InputValidationException("field is not valid");
		}
		
		if(this.pageStart >= this.pageEnd) {
			throw new InputValidationException("page end should be greater than page start");
		}
	}
	
}
