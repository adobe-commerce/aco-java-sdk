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

/** FeedProductDelete */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class FeedProductDelete {
    public static final String SERIALIZED_NAME_SKU = "sku";

    @SerializedName(SERIALIZED_NAME_SKU)
    private String sku;

    public static final String SERIALIZED_NAME_SOURCE = "source";

    @SerializedName(SERIALIZED_NAME_SOURCE)
    private Source source;

    public FeedProductDelete() {}

    public FeedProductDelete sku(String sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Product unique identifier
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

    public FeedProductDelete source(Source source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     */
    @javax.annotation.Nonnull
    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FeedProductDelete feedProductDelete = (FeedProductDelete) o;
        return Objects.equals(this.sku, feedProductDelete.sku)
                && Objects.equals(this.source, feedProductDelete.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, source);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FeedProductDelete {\n");
        sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
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
        openapiFields.add("source");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("sku");
        openapiRequiredFields.add("source");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to FeedProductDelete
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!FeedProductDelete.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in FeedProductDelete is not found in the empty JSON string",
                                FeedProductDelete.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!FeedProductDelete.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `FeedProductDelete` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : FeedProductDelete.openapiRequiredFields) {
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
        // validate the required field `source`
        Source.validateJsonElement(jsonObj.get("source"));
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!FeedProductDelete.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'FeedProductDelete' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<FeedProductDelete> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(FeedProductDelete.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<FeedProductDelete>() {
                        @Override
                        public void write(JsonWriter out, FeedProductDelete value)
                                throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public FeedProductDelete read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of FeedProductDelete given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of FeedProductDelete
     * @throws IOException if the JSON string is invalid with respect to FeedProductDelete
     */
    public static FeedProductDelete fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, FeedProductDelete.class);
    }

    /**
     * Convert an instance of FeedProductDelete to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
