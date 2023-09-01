package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private int status;
    private String message;

    public ApiResponse() {
    }
    

    public boolean isSuccess() {
        return status >= 200 && status < 300;
    }

    public ApiResponse(String message, int status) {
        this.status = status;
        this.message = message;
    }




}
