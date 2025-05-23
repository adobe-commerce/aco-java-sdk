package com.adobe.aco.error;

public class ApiError extends CommerceSdkError {
    private final int statusCode;
    private final Object response;

    public ApiError(String message, int statusCode, Object response) {
        super(message);
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Object getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "APIError: " + getMessage() + " (Status Code: " + statusCode + ")";
    }
}
