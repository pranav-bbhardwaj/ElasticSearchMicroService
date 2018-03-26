package org.testmicro.analytics.store;

import org.testmicro.analytics.exception.StoreException;
import org.testmicro.analytics.rest.service.SearchRequest;

public interface IStore {

	StoreResponse search(SearchRequest request) throws StoreException;
}
