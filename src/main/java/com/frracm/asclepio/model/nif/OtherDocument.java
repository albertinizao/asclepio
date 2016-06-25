package com.frracm.asclepio.model.nif;

public class OtherDocument implements NIF {
	private final String document; 
	
	public OtherDocument (String document){
		this.document = document;
	}

	public String getValue() {
		return document;
	}

}
