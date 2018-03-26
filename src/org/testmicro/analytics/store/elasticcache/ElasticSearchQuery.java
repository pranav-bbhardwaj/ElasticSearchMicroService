package org.testmicro.analytics.store.elasticcache;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElasticSearchQuery {

	@Expose
	@SerializedName("query_string")
	private ElasticQueryString elasticQueryString;

	public ElasticQueryString getElasticQueryString() {
		return elasticQueryString;
	}

	public void setElasticQueryString(ElasticQueryString elasticQueryString) {
		this.elasticQueryString = elasticQueryString;
	}
	
	public ElasticSearchQuery withElasticQueryString(ElasticQueryString queryString) {
		this.elasticQueryString = queryString;
		return this;
	}

	@Override
	public String toString() {
		return "ElasticSearchQuery [elasticQueryString=" + elasticQueryString
				+ "]";
	}	

}
