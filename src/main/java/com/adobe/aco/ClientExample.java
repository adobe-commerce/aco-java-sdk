package com.adobe.aco;

import com.adobe.aco.client.Client;
import com.adobe.aco.client.ClientBuilder;
import com.adobe.aco.error.ApiError;
import com.adobe.aco.model.*;
import java.util.Arrays;
import java.util.List;

public class ClientExample {

    public static void main(String[] args) {
        // Load required environment variables
        String clientId = System.getenv("IMS_CLIENT_ID");
        String clientSecret = System.getenv("IMS_CLIENT_SECRET");
        String tenantId = System.getenv("TENANT_ID");
        String region = System.getenv("REGION");
        String environment = System.getenv("ENVIRONMENT");

        if (clientId == null
                || clientId.isBlank()
                || clientSecret == null
                || clientSecret.isBlank()
                || tenantId == null
                || tenantId.isBlank()
                || region == null
                || region.isBlank()
                || environment == null
                || environment.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing one or more required environment variables.");
        }

        ClientConfig config =
                new ClientConfig(
                        new AdobeCredentials(clientId, clientSecret),
                        tenantId,
                        Region.valueOf(region.toUpperCase()),
                        Environment.valueOf(environment.toUpperCase()));

        Client client = ClientBuilder.createClient(config);

        FeedProduct product1 = new FeedProduct();
        product1.setSku("EXAMPLE-SKU-001");
        Scope scope1 = new Scope();
        scope1.setLocale("en-US");
        product1.setScope(scope1);
        product1.setName("Example Product 1");
        product1.setSlug("example-product-1");
        product1.setDescription("This is an example product created via the SDK");
        product1.setStatus(FeedProduct.StatusEnum.ENABLED);
        product1.setVisibleIn(
                Arrays.asList(FeedProduct.VisibleInEnum.CATALOG, FeedProduct.VisibleInEnum.SEARCH));

        ProductAttribute productAttribute = new ProductAttribute();
        productAttribute.setType(ProductAttribute.TypeEnum.STRING);
        productAttribute.setValues(List.of("Example Brand"));
        product1.setAttributes(List.of(productAttribute));

        FeedProduct product2 = new FeedProduct();
        product2.setSku("EXAMPLE-SKU-002");
        Scope scope2 = new Scope();
        scope2.setLocale("en-US");
        product2.setScope(scope2);
        product2.setName("Example Product 2");
        product2.setSlug("example-product-2");
        product2.setDescription("This is another example product created via the SDK");
        product2.setStatus(FeedProduct.StatusEnum.DISABLED);
        product2.setVisibleIn(
                Arrays.asList(FeedProduct.VisibleInEnum.CATALOG, FeedProduct.VisibleInEnum.SEARCH));

        ProductAttribute productAttribute2 = new ProductAttribute();
        productAttribute2.setType(ProductAttribute.TypeEnum.STRING);
        productAttribute2.setValues(List.of("Example Brand"));
        product2.setAttributes(List.of(productAttribute2));

        try {

            ProcessFeedResponse response = client.createProducts(List.of(product1, product2));

            System.out.println("Products created successfully: " + response);
        } catch (Exception e) {
            Throwable cause = e.getCause();

            if (cause instanceof ApiError) {
                ApiError apiError = (ApiError) cause;
                System.err.println("API error: " + apiError.getStatusCode());
                System.err.println("Response: " + apiError.getResponse());
            } else {
                System.err.println("Error creating products: " + e.getMessage());
            }
        }
    }
}
