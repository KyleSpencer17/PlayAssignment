package com.spencer.playSafe.controllers;

import java.sql.Time;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	@PostMapping(value = "/conversions/ktoc", 
			produces = {MediaType.APPLICATION_JSON_VALUE }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TempResponse>convertCelcius(@RequestBody TempRequest request) {
		Long start = System.currentTimeMillis();
		try {
			Double convertedTemp = service.convertToCelcius(request.getTemperature());
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.ok().body(new TempResponse("Success", convertedTemp));
			}

		catch(Exception e) {
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.badRequest().body(new TempResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping(value = "/conversions/ctok", 
			produces = {MediaType.APPLICATION_JSON_VALUE }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TempResponse>convertKelvin(@RequestBody TempRequest request) {
		Long start = System.currentTimeMillis();
		try {
			Double convertedTemp = service.convertToKelvin(request.getTemperature());
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.ok().body(new TempResponse("Success", convertedTemp));
			}

		catch(Exception e) {
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.badRequest().body(new TempResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping(value = "/conversions/mtok", 
			produces = {MediaType.APPLICATION_JSON_VALUE }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DistResponse>convertToKilometres(@RequestBody DistRequest request) {
		Long start = System.currentTimeMillis();
		try {
			Double kilometres = service.convertToKilometres(request.getDistance());
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.ok().body(new DistResponse("Success", kilometres));
			}

		catch(Exception e) {
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.badRequest().body(new DistResponse(e.getMessage(), 0.00));
		}
	}
	
	@PostMapping(value = "/conversions/ktom", 
			produces = {MediaType.APPLICATION_JSON_VALUE }, 
			consumes = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<DistResponse>convertToMiles(@RequestBody DistRequest request) {
		Long start = System.currentTimeMillis();
		try {
			Double miles = service.convertToMiles(request.getDistance());
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.ok().body(new DistResponse("Success", miles));
			}

		catch(Exception e) {
			System.out.println((System.currentTimeMillis() - start) + "ms");
			return ResponseEntity.badRequest().body(new DistResponse(e.getMessage(), 0.00));
		}
	}
}
