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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.openapitools.jackson.nullable.JsonNullable;

/** ProductAttribute */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class ProductAttribute {
    public static final String SERIALIZED_NAME_CODE = "code";

    @SerializedName(SERIALIZED_NAME_CODE)
    private String code;

    public static final String SERIALIZED_NAME_VALUES = "values";

    @SerializedName(SERIALIZED_NAME_VALUES)
    private List<String> values = new ArrayList<>();

    public static final String SERIALIZED_NAME_VARIANT_REFERENCE_ID = "variantReferenceId";

    @SerializedName(SERIALIZED_NAME_VARIANT_REFERENCE_ID)
    private String variantReferenceId;

    public ProductAttribute() {}

    public ProductAttribute code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Product Attribute Code
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

    public ProductAttribute values(List<String> values) {
        this.values = values;
        return this;
    }

    public ProductAttribute addValuesItem(String valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * A list of value(s) associated with a specified attribute code.
     *
     * @return values
     */
    @javax.annotation.Nonnull
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public ProductAttribute variantReferenceId(String variantReferenceId) {
        this.variantReferenceId = variantReferenceId;
        return this;
    }

    /**
     * The variant reference ID establishes a link between a product variant and the corresponding
     * [Option Value ID](#operation/createProducts!path&#x3D;options/values/id&amp;t&#x3D;request)
     * in a configurable product. A variant reference ID can be specified only for a product that
     * represents a variant of a configurable product.
     *
     * @return variantReferenceId
     */
    @javax.annotation.Nullable
    public String getVariantReferenceId() {
        return variantReferenceId;
    }

    public void setVariantReferenceId(String variantReferenceId) {
        this.variantReferenceId = variantReferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductAttribute productAttribute = (ProductAttribute) o;
        return Objects.equals(this.code, productAttribute.code)
                && Objects.equals(this.values, productAttribute.values)
                && Objects.equals(this.variantReferenceId, productAttribute.variantReferenceId);
    }

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b
                || (a != null
                        && b != null
                        && a.isPresent()
                        && b.isPresent()
                        && Objects.deepEquals(a.get(), b.get()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, values, variantReferenceId);
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[] {a.get()}) : 31;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductAttribute {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("    variantReferenceId: ")
                .append(toIndentedString(variantReferenceId))
                .append("\n");
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
        openapiFields.add("values");
        openapiFields.add("variantReferenceId");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("code");
        openapiRequiredFields.add("values");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ProductAttribute
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ProductAttribute.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in ProductAttribute is not found in the empty JSON string",
                                ProductAttribute.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ProductAttribute.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `ProductAttribute` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ProductAttribute.openapiRequiredFields) {
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
        // ensure the required json array is present
        if (jsonObj.get("values") == null) {
            throw new IllegalArgumentException(
                    "Expected the field `linkedContent` to be an array in the JSON string but got `null`");
        } else if (!jsonObj.get("values").isJsonArray()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `values` to be an array in the JSON string but got `%s`",
                            jsonObj.get("values").toString()));
        }
        if ((jsonObj.get("variantReferenceId") != null
                        && !jsonObj.get("variantReferenceId").isJsonNull())
                && !jsonObj.get("variantReferenceId").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `variantReferenceId` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("variantReferenceId").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ProductAttribute.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ProductAttribute' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ProductAttribute> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(ProductAttribute.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<ProductAttribute>() {
                        @Override
                        public void write(JsonWriter out, ProductAttribute value)
                                throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public ProductAttribute read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of ProductAttribute given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProductAttribute
     * @throws IOException if the JSON string is invalid with respect to ProductAttribute
     */
    public static ProductAttribute fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ProductAttribute.class);
    }

    /**
     * Convert an instance of ProductAttribute to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
