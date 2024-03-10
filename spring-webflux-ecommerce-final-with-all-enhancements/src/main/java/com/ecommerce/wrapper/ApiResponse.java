
package com.ecommerce.wrapper;

public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse() {}

    public ApiResponse(T data) {
        this.data = data;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
