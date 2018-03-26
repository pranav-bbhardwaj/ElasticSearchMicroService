package org.testmicro.analytics.exception;


public class StoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4229099777940339672L;
	
	public StoreException(Throwable t) {
		super(t);
	}
	
	public StoreException(String error) {
		super(error);
	}
	
	public StoreException(String error, Throwable t) {
		super(error,t);
	}
}
