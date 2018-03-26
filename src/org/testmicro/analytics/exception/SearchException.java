package org.testmicro.analytics.exception;

public class SearchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6894096264916345588L;
	public SearchException(Throwable t) {
		super(t);
	}
	
	public SearchException(String error) {
		super(error);
	}
	
	public SearchException(String error, Throwable t) {
		super(error,t);
	}
}
