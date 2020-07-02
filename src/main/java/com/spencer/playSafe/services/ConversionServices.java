package com.spencer.playSafe.services;

public class ConversionServices {
	public Double convertToCelcius(Double temperature) {
		return temperature - 273.15;
	}
	
	public Double convertToKelvin(Double temperature) {
		return temperature + 273.15;
	}

	public Double convertToKilometres(Double distance) {
		return distance / 5 * 8;
	}
	
	public Double convertToMiles(Double distance) {
		return distance / 8 * 5;
	}
}
