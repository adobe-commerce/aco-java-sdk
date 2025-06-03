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
    private static final int INITIAL_RETRY_DELAY_MS = 1000;

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

                String token = auth.getBearerToken();

                String fullUri = String.format("%s/%s%s", baseUrl, tenantId, endpoint);

                HttpRequest request =
                        requestBuilder
                                .uri(URI.create(fullUri))
                                .header("Content-Type", "application/json")
                                .header("Authorization", "Bearer " + token)
                                .timeout(Duration.ofMillis(TIMEOUT_MS))
                                .build();

                for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
                    try {
                        HttpResponse<String> response =
                                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                        int status = response.statusCode();

                        if (status >= 200 && status < 300) {
                            return mapper.readValue(response.body(), responseType);
                        }

                        String errorData = response.body();

                        if (status == 429) {
                            if (attempt == MAX_RETRIES) {
                                throw new ApiError(
                                        "Rate limit exceeded after retries", status, errorData);
                            }
                            Thread.sleep(calculateBackoffDelay(attempt));
                            continue;
                        }

                        if (status >= 400 && status < 500) {
                            throw new ApiError("Client error: " + status, status, errorData);
                        }

                        if (attempt == MAX_RETRIES) {
                            throw new ApiError("Server error after retries", status, errorData);
                        }

                        Thread.sleep(calculateBackoffDelay(attempt));

                    } catch (ApiError e) {
                        throw e;
                    } catch (Exception e) {
                        if (attempt == MAX_RETRIES) {
                            throw new ApiError("Could not execute request", 0, e.getMessage());
                        }
                        Thread.sleep(calculateBackoffDelay(attempt));
                    }
                }

                throw new ApiError(
                        "Unexpected error executing request",
                        0,
                        "Retries exhausted with unknown failure");
            }
        };
    }

    private static int calculateBackoffDelay(int attempt) {
        return INITIAL_RETRY_DELAY_MS * (int) Math.pow(2, attempt - 1);
    }
}
