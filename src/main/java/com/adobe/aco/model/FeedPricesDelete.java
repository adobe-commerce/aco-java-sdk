/*************************************************************************
 * ADOBE CONFIDENTIAL
 * ___________________
 * <p>
 *  Copyright 2025 Adobe
 *  All Rights Reserved.
 * <p>
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe and its suppliers, if any. The intellectual
 * and technical concepts contained herein are proprietary to Adobe
 * and its suppliers and are protected by all applicable intellectual
 * property laws, including trade secret and copyright laws.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe.
 * <p>
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech)
 * using custom templates. Generator configuration can be found in the /generator directory.
 * <p>
 * Do not edit this file manually!
 **************************************************************************/

package com.adobe.aco.model;

import com.adobe.aco.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/** Delete product price information. */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class FeedPricesDelete {
    public static final String SERIALIZED_NAME_SKU = "sku";

    @SerializedName(SERIALIZED_NAME_SKU)
    private String sku;

    public static final String SERIALIZED_NAME_PRICE_BOOK_ID = "priceBookId";

    @SerializedName(SERIALIZED_NAME_PRICE_BOOK_ID)
    private String priceBookId;

    public FeedPricesDelete() {}

    public FeedPricesDelete sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Product SKU
     *
     * @return sku
     */
    @javax.annotation.Nonnull
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public FeedPricesDelete priceBookId(String priceBookId) {
        this.priceBookId = priceBookId;
        return this;
    }

    /**
     * Price book id
     *
     * @return priceBookId
     */
    @javax.annotation.Nonnull
    public String getPriceBookId() {
        return priceBookId;
    }

    public void setPriceBookId(String priceBookId) {
        this.priceBookId = priceBookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FeedPricesDelete feedPricesDelete = (FeedPricesDelete) o;
        return Objects.equals(this.sku, feedPricesDelete.sku)
                && Objects.equals(this.priceBookId, feedPricesDelete.priceBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, priceBookId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FeedPricesDelete {\n");
        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    priceBookId: ").append(toIndentedString(priceBookId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("sku");
        openapiFields.add("priceBookId");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("sku");
        openapiRequiredFields.add("priceBookId");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to FeedPricesDelete
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!FeedPricesDelete.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in FeedPricesDelete is not found in the empty JSON string",
                                FeedPricesDelete.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!FeedPricesDelete.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `FeedPricesDelete` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : FeedPricesDelete.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                        String.format(
                                "The required field `%s` is not found in the JSON string: %s",
                                requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("sku").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `sku` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("sku").toString()));
        }
        if (!jsonObj.get("priceBookId").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `priceBookId` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("priceBookId").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!FeedPricesDelete.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'FeedPricesDelete' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FeedPricesDelete> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(FeedPricesDelete.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<FeedPricesDelete>() {
                        @Override
                        public void write(JsonWriter out, FeedPricesDelete value)
                                throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public FeedPricesDelete read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of FeedPricesDelete given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of FeedPricesDelete
     * @throws IOException if the JSON string is invalid with respect to FeedPricesDelete
     */
    public static FeedPricesDelete fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, FeedPricesDelete.class);
    }

    /**
     * Convert an instance of FeedPricesDelete to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
