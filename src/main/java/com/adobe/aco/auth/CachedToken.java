package com.adobe.aco.auth;

public class CachedToken {
    public String token;
    public long expiresAt;

    public CachedToken(String token, long expiresAt) {
        this.token = token;
        this.expiresAt = expiresAt;
    }
}
