package com.spencer.playSafe.services;

public class ConversionServices {
	public Double convertToCelcius(Double temperature) {
		return temperature - 273.15;
	}
	
	public Double convertToKelvin(Double temperature) {
		return temperature + 273.15;
	}
}
