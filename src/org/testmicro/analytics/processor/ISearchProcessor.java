package org.testmicro.analytics.processor;

import org.testmicro.analytics.exception.SearchException;
import org.testmicro.analytics.rest.service.SearchRequest;
import org.testmicro.analytics.rest.service.SearchResponse;

public interface ISearchProcessor {

	SearchResponse process (SearchRequest request) throws SearchException;
}
