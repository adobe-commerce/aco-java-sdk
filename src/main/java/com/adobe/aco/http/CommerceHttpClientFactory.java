package com.adobe.aco.http;

import com.adobe.aco.auth.AuthService;
import com.adobe.aco.error.ApiError;
import com.adobe.aco.model.Environment;
import com.adobe.aco.model.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CommerceHttpClientFactory {

    private static final int TIMEOUT_MS = 10000;
    private static final int MAX_RETRIES = 3;
    private static final int RETRY_DELAY_MS = 1000;

    public static CommerceHttpClient createHttpClient(
            AuthService auth,
            String tenantId,
            Region region,
            Environment environment,
            String baseUrlOverride) {
        String regionStr = region.name().toLowerCase();
        String envStr = environment.name().toLowerCase();
        String baseUrl =
                (baseUrlOverride != null && !baseUrlOverride.isEmpty())
                        ? baseUrlOverride
                        : String.format(
                                "https://%s%s.api.commerce.adobe.com",
                                regionStr, "production".equals(envStr) ? "" : "-sandbox");

        HttpClient httpClient =
                HttpClient.newBuilder().connectTimeout(Duration.ofMillis(TIMEOUT_MS)).build();

        return new CommerceHttpClient() {
            @Override
            public <T> T request(
                    String endpoint, HttpRequest.Builder requestBuilder, Class<T> responseType)
                    throws Exception {
                ObjectMapper mapper = new ObjectMapper();
                System.out.println("Iniciando request para " + endpoint);

                String token = auth.getBearerToken();

                System.out.println("Token: " + token);

                String fullUri = String.format("%s/%s%s", baseUrl, tenantId, endpoint);

                HttpRequest request =
                        requestBuilder
                                .uri(URI.create(fullUri))
                                .header("Content-Type", "application/json")
                                .header("Authorization", "Bearer " + token)
                                .timeout(Duration.ofMillis(TIMEOUT_MS))
                                .build();

                System.out.println("Request URI: " + request.uri());
                System.out.println("Request method: " + request.method());
                System.out.println("Request headers:");
                request.headers()
                        .map()
                        .forEach(
                                (key, values) ->
                                        System.out.println(
                                                "  " + key + ": " + String.join(", ", values)));

                for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
                    try {
                        HttpResponse<String> response =
                                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                        if (response.statusCode() >= 200 && response.statusCode() < 300) {
                            return mapper.readValue(response.body(), responseType);
                        } else {
                            String errorData = response.body();
                            if (attempt == MAX_RETRIES
                                    || (response.statusCode() >= 400
                                            && response.statusCode() < 500)) {
                                throw new ApiError(
                                        "API request failed: " + response.statusCode(),
                                        response.statusCode(),
                                        errorData);
                            }
                            Thread.sleep(RETRY_DELAY_MS * attempt);
                        }
                    } catch (ApiError e) {
                        throw e;
                    } catch (Exception e) {
                        if (attempt == MAX_RETRIES) {
                            throw new ApiError("Could not execute request", 0, e.getMessage());
                        }
                        Thread.sleep(RETRY_DELAY_MS * attempt);
                    }
                }

                throw new ApiError(
                        "Unexpected error executing request",
                        0,
                        "Retries exhausted with unknown failure");
            }
        };
    }
}
