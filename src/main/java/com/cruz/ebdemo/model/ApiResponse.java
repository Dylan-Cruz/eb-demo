package com.cruz.ebdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Generic api response container pojo. Has two elements error and data.
 * Data is a generic type
 * @param <T> Type of object to be held in the data field
 */
@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String error;

    public ApiResponse (T data) {
        this.data = data;
    }

    public ApiResponse (String error) {
        this.error = error;
    }
}