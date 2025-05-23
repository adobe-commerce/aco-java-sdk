package com.adobe.aco.error;

public class ConfigurationError extends CommerceSdkError {
    public ConfigurationError(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ConfigurationError: " + getMessage();
    }
}
