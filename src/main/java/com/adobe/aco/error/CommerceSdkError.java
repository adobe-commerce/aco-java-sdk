package com.adobe.aco.error;

public class CommerceSdkError extends RuntimeException {
    public CommerceSdkError(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "CommerceSDKError: " + getMessage();
    }
}
