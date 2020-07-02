package com.spencer.playSafe.requestAndResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TempResponse {
	String status;
	Double temperature;
}
