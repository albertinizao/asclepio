package com.frracm.asclepio.model.nif;

public class DNI implements SpanishNIF {
	private final Integer numero;
	private final char letra;

	public DNI(Integer numero, char letra) {
		this.numero = numero;
		this.letra = letra;
		if (!isValid()) {
			throw new IllegalArgumentException("DNI erróneo");
		}
	};

	public String getValue() {
		return numero.toString() + letra;
	}

	public boolean isValid() {
		boolean response = true;
		int rest = numero % 23;
		if (letra != LETTER_DNI[rest]) {
			response = false;
		}
		if (numero == null || numero > 99999999 || numero < 1){
			response = false;
		}
	return response;
	}
	
}
