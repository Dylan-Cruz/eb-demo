package com.cruz.ebdemo.model;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private String error;
}