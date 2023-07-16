package com.laptrinhweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
	private String message;
	private Object data;

	public ResponseObject(String message) {
		super();
		this.message = message;
	}

}
