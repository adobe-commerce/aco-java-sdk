package com.adobe.aco.http;

public interface CommerceHttpClient {
    <T> T request(
            String endpoint,
            java.net.http.HttpRequest.Builder requestBuilder,
            Class<T> responseType)
            throws Exception;
}
