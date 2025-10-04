package com.genomatogenoma.togenoma.utils.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>(true, message, data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data, String message){
        ApiResponse<T> response = new ApiResponse<>(true, message, data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public static ResponseEntity<ApiResponse<Object>> error(String message, HttpStatus status){
        ApiResponse<Object> response = new ApiResponse<>(false, message, null);
        return new ResponseEntity<>(response, status);
    }
}
