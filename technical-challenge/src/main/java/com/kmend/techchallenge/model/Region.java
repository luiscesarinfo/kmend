package com.kmend.techchallenge.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Region {

	UNITED_STATES("United States"),
	EUROPE("Europe"),
	APAC("APAC"),
	LATIN_AMERICA("Latin America");
	
	private String label;
	
	Region(String label) {
		this.label = label;
	}

	@JsonValue
	public String getLabel() {
		return label;
	}

	public static Region valueOfLabel(String label) {
	    for (Region region : values()) {
	        if (region.getLabel().equalsIgnoreCase(label)) {
	            return region;
	        }
	    }
	    return null;
	}

}
