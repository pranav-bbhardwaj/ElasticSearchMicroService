package org.testmicro.analytics.rest.service;

public enum SupportedFields {

	PLAN_NAME("PLAN_NAME"),
	STATE_NAME("PLAN_NAME"),
	SPONSOR_NAME("SPONSOR_DFE_NAME");
	
	private final String fieldName; 
	
	SupportedFields(String fieldName) {
        this.fieldName = fieldName;
    }
	
	public String getFieldName() {
		return fieldName;
	}
}
