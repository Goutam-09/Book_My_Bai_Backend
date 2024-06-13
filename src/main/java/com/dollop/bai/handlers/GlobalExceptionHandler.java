package com.dollop.bai.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.exceptions.DublicateEntryException;
import com.dollop.bai.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponse response = ApiResponse.builder().success(true).message(ex.getMessage()).status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DublicateEntryException.class)
	public ResponseEntity<ApiResponse> dublicateEntryException(DublicateEntryException ex) {
		ApiResponse response = ApiResponse.builder().success(false).message(ex.getMessage())
				.status(HttpStatus.BAD_REQUEST).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		Map<String, Object> map = new HashMap<>();
		ex.getBindingResult().getFieldErrors().stream().forEach((error) -> {
			map.put(error.getField(), error.getDefaultMessage());
		});
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		ApiResponse response = ApiResponse.builder().success(true).message(ex.getMessage())
				.status(HttpStatus.BAD_REQUEST).build();
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
