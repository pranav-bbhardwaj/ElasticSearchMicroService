package org.testmicro.analytics.exception;

public class InputValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -417562380185619747L;
	public InputValidationException(Throwable t) {
		super(t);
	}
	
	public InputValidationException(String error) {
		super(error);
	}
	
	public InputValidationException(String error, Throwable t) {
		super(error,t);
	}
}
