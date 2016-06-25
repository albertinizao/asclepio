package com.frracm.asclepio.model.nif;

public interface SpanishNIF extends NIF {
	static char[] LETTER_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	
	boolean isValid();
}
