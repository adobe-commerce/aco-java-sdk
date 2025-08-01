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

/**
 * Percentage discount that reduces the regular price by a specified percentage. Example: $100
 * regular price with a 20% discount results in $80 final price.
 */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class DiscountsPercentage {
    public static final String SERIALIZED_NAME_CODE = "code";

    @SerializedName(SERIALIZED_NAME_CODE)
    private String code;

    public static final String SERIALIZED_NAME_PERCENTAGE = "percentage";

    @SerializedName(SERIALIZED_NAME_PERCENTAGE)
    private Float percentage;

    public DiscountsPercentage() {}

    public DiscountsPercentage code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Unique identifier for the discount. Must be unique within the price record. Use descriptive
     * codes for easier management (e.g., \&quot;seasonal_sale\&quot;, \&quot;vip_member\&quot;).
     *
     * @return code
     */
    @javax.annotation.Nonnull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DiscountsPercentage percentage(Float percentage) {
        this.percentage = percentage;
        return this;
    }

    /**
     * Discount percentage as a positive number. Valid range is 0.01 to 99.99 (1% to 99.99%).
     *
     * @return percentage
     */
    @javax.annotation.Nonnull
    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiscountsPercentage discountsPercentage = (DiscountsPercentage) o;
        return Objects.equals(this.code, discountsPercentage.code)
                && Objects.equals(this.percentage, discountsPercentage.percentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, percentage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscountsPercentage {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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
        openapiFields.add("code");
        openapiFields.add("percentage");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("code");
        openapiRequiredFields.add("percentage");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to DiscountsPercentage
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!DiscountsPercentage.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in DiscountsPercentage is not found in the empty JSON string",
                                DiscountsPercentage.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!DiscountsPercentage.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `DiscountsPercentage` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : DiscountsPercentage.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                        String.format(
                                "The required field `%s` is not found in the JSON string: %s",
                                requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("code").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `code` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("code").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!DiscountsPercentage.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'DiscountsPercentage' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<DiscountsPercentage> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(DiscountsPercentage.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<DiscountsPercentage>() {
                        @Override
                        public void write(JsonWriter out, DiscountsPercentage value)
                                throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public DiscountsPercentage read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of DiscountsPercentage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of DiscountsPercentage
     * @throws IOException if the JSON string is invalid with respect to DiscountsPercentage
     */
    public static DiscountsPercentage fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, DiscountsPercentage.class);
    }

    /**
     * Convert an instance of DiscountsPercentage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
