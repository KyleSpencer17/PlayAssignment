package com.spencer.playSafe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spencer.playSafe.requestAndResponse.DistRequest;
import com.spencer.playSafe.requestAndResponse.DistResponse;
import com.spencer.playSafe.requestAndResponse.TempRequest;
import com.spencer.playSafe.requestAndResponse.TempResponse;
import com.spencer.playSafe.services.ConversionServices;

@RestController
public class ConversiomController {
	@Autowired
	ConversionServices service;

	@PostMapping("/conversions/ktoc")
	public ResponseEntity<TempResponse>convertCelcius(@RequestBody TempRequest request) {
		try {
			Double convertedTemp = service.convertToCelcius(request.getTemperature());
			return ResponseEntity.ok().body(new TempResponse("Success", convertedTemp));
			}

		catch(Exception e) {
			return ResponseEntity.badRequest().body(new TempResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping("/conversions/ctok")
	public ResponseEntity<TempResponse>convertKelvin(@RequestBody TempRequest request) {
		try {
			Double convertedTemp = service.convertToKelvin(request.getTemperature());
			return ResponseEntity.ok().body(new TempResponse("Success", convertedTemp));
			}

		catch(Exception e) {
			return ResponseEntity.badRequest().body(new TempResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping("/conversions/mtok")
	public ResponseEntity<DistResponse>convertToKilometres(@RequestBody DistRequest request) {
		try {
			Double kilometres = service.convertToKilometres(request.getDistance());
			return ResponseEntity.ok().body(new DistResponse("Success", kilometres));
			}

		catch(Exception e) {
			return ResponseEntity.badRequest().body(new DistResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping("/conversions/ktom")
	public ResponseEntity<DistResponse>convertToMiles(@RequestBody DistRequest request) {
		try {
			Double miles = service.convertToMiles(request.getDistance());
			return ResponseEntity.ok().body(new DistResponse("Success", miles));
			}

		catch(Exception e) {
			return ResponseEntity.badRequest().body(new DistResponse(e.getMessage(), 0.00));
		}
	}
}
