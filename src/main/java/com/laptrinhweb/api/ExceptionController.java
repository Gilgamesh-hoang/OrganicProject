package com.laptrinhweb.api;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)

	public Map<String, String> conflictData(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Code", "409");
		map.put("Error", "Conflict Data");
		return map;
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public Map<String, String> methodNotSupportedException(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Code", "405");
		map.put("Error", "Method not allowed");
		return map;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> badRequestHandler(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Code", "400");
		map.put("Error", "Params are wrong types");
		return map;
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> nullPoiter(Exception ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Code", "500");
		map.put("Error", "Cannot invoke object because it's null");
		return map;
	}
}
