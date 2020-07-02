package com.spencer.playSafe.requestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistResponse {
	private String status;
	private Double distance;
}
