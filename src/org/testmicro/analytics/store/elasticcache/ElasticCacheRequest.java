package org.testmicro.analytics.store.elasticcache;


import com.google.gson.annotations.Expose;

public class ElasticCacheRequest {

	@Expose
	private Integer from;
	
	@Expose
	private Integer size;
	
	@Expose
	private ElasticSearchQuery query;

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}
	
	public ElasticCacheRequest withFrom(Integer from) {
		this.from = from;
		return this;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	public ElasticCacheRequest withSize(Integer size) {
		this.size = size;
		return this;
	}

	public ElasticSearchQuery getQuery() {
		return query;
	}

	public void setQuery(ElasticSearchQuery query) {
		this.query = query;
	}
	
	public ElasticCacheRequest withQuery(ElasticSearchQuery query) {
		this.query = query;
		return this;
	}

	@Override
	public String toString() {
		return "EleasticCacheRequest [from=" + from + ", size=" + size
				+ ", query=" + query + "]";
	}
	
	
}
