package com.adobe.aco.auth;

import com.adobe.aco.error.ConfigurationError;
import com.adobe.aco.model.AdobeCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class AuthServiceFactory {
    private static final String IMS_BASE_URL = "https://ims-na1.adobelogin.com";
    private static final int TOKEN_BUFFER_SECONDS = 300;
    private static final String DEFAULT_SCOPES = "adobeio_api,openid,AdobeID,read_organizations";
    private static CachedToken cachedToken = null;

    public static AuthService createAuthService(
            AdobeCredentials credentials, String imsBaseUrlOverride) {
        if (credentials.getClientId() == null || credentials.getClientSecret() == null) {
            throw new ConfigurationError("Required credentials are missing");
        }

        String imsTokenEndpoint =
                (imsBaseUrlOverride != null ? imsBaseUrlOverride : IMS_BASE_URL) + "/ims/token/v3";

        return () -> {
            long currentTime = Instant.now().toEpochMilli();
            if (cachedToken != null
                    && cachedToken.expiresAt > (currentTime + TOKEN_BUFFER_SECONDS * 1000)) {
                return cachedToken.token;
            }

            String form =
                    String.format(
                            "client_id=%s&client_secret=%s&grant_type=client_credentials&scope=%s",
                            URLEncoder.encode(credentials.getClientId(), StandardCharsets.UTF_8),
                            URLEncoder.encode(
                                    credentials.getClientSecret(), StandardCharsets.UTF_8),
                            URLEncoder.encode(DEFAULT_SCOPES, StandardCharsets.UTF_8));

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(URI.create(imsTokenEndpoint))
                            .header("Content-Type", "application/x-www-form-urlencoded")
                            .POST(HttpRequest.BodyPublishers.ofString(form))
                            .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException(
                        "Failed to get authentication token: " + response.body());
            }

            ObjectMapper mapper = new ObjectMapper();
            TokenResponse tokenResponse = mapper.readValue(response.body(), TokenResponse.class);

            cachedToken =
                    new CachedToken(
                            tokenResponse.access_token,
                            Instant.now().toEpochMilli() + tokenResponse.expires_in * 1000L);

            return tokenResponse.access_token;
        };
    }
}
