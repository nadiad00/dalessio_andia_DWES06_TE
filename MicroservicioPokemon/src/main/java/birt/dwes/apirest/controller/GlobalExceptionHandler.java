package birt.dwes.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

import birt.dwes.apirest.utils.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse> handleResponseStatusException(ResponseStatusException ex) {
        ApiResponse response = new ApiResponse(
                "error",
                ex.getStatusCode().value(),
                ex.getReason(),
                null
        );
        return new ResponseEntity<>(response, ex.getStatusCode());
    }
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(NoHandlerFoundException ex) {
        ApiResponse response = new ApiResponse(
                "error",
                404,
                "URL no encontrada: " + ex.getRequestURL(),
                null
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
