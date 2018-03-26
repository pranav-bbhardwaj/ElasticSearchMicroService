package org.testmicro.analytics.store.elasticcache;

import java.util.Arrays;

import com.google.gson.annotations.Expose;

public class ElasticQueryString {

	@Expose
	private String query;
	
	@Expose
	private String[] fields;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	public ElasticQueryString withQuery(String query) {
		this.query = query;
		return this;
	}


	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	public ElasticQueryString withFields(String[] fields) {
		this.fields = fields;
		return this;
	}

	@Override
	public String toString() {
		return "ElasticQueryString [query=" + query + ", fields="
				+ Arrays.toString(fields) + "]";
	}
	
	
}
