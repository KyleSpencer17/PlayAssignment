package com.spencer.playSafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversiomController {
	@Autowired
	ConversionServices service;

	@PostMapping(/conversions/ktoc)
	public ResponseEntity<TempResponse>convertTemperature(@RequestBody TempRequest request) {
		try {
			Double convertedTemp = service.convertTemperature(request.temperature) {
			return ResponseEntity.ok().body(new TempResponse(convertedTemp));
			}
		}
		catch() {
			
		}
	}
}
