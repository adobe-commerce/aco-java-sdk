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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
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

/** ProductConfiguration */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class ProductConfiguration {
    public static final String SERIALIZED_NAME_ATTRIBUTE_CODE = "attributeCode";

    @SerializedName(SERIALIZED_NAME_ATTRIBUTE_CODE)
    private String attributeCode;

    public static final String SERIALIZED_NAME_LABEL = "label";

    @SerializedName(SERIALIZED_NAME_LABEL)
    private String label;

    public static final String SERIALIZED_NAME_DEFAULT_VARIANT_REFERENCE_ID =
            "defaultVariantReferenceId";

    @SerializedName(SERIALIZED_NAME_DEFAULT_VARIANT_REFERENCE_ID)
    private String defaultVariantReferenceId;

    /**
     * Option type. Indicates the product type the option can be assigned to. -
     * &#x60;CONFIGURABLE&#x60;: Configurable product option - &#x60;SWATCH&#x60;: Swatch product
     * option. Must be used for color or text swatches attributes
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        CONFIGURABLE("CONFIGURABLE"),

        SWATCH("SWATCH");

        private String value;

        TypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration)
                    throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TypeEnum.fromValue(value);
            }
        }

        public static void validateJsonElement(JsonElement jsonElement) throws IOException {
            String value = jsonElement.getAsString();
            TypeEnum.fromValue(value);
        }
    }

    public static final String SERIALIZED_NAME_TYPE = "type";

    @SerializedName(SERIALIZED_NAME_TYPE)
    private TypeEnum type;

    public static final String SERIALIZED_NAME_VALUES = "values";

    @SerializedName(SERIALIZED_NAME_VALUES)
    private List<ProductOptionValue> values = new ArrayList<>();

    public ProductConfiguration() {}

    public ProductConfiguration attributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
        return this;
    }

    /**
     * Product option attribute code. For &#x60;CONFIGURABLE&#x60; or &#x60;SWATCH&#x60; option
     * types, this ID must match the [\&quot;attribute
     * code\&quot;](#operation/createProducts!path&#x3D;attributes/code&amp;t&#x3D;request) used for
     * the configurable product (for example, \&quot;color\&quot;).
     *
     * @return attributeCode
     */
    @javax.annotation.Nonnull
    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public ProductConfiguration label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Option label
     *
     * @return label
     */
    @javax.annotation.Nullable
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProductConfiguration defaultVariantReferenceId(String defaultVariantReferenceId) {
        this.defaultVariantReferenceId = defaultVariantReferenceId;
        return this;
    }

    /**
     * Specifies the pre-selected value variant reference id of the current option.
     *
     * @return defaultVariantReferenceId
     */
    @javax.annotation.Nullable
    public String getDefaultVariantReferenceId() {
        return defaultVariantReferenceId;
    }

    public void setDefaultVariantReferenceId(String defaultVariantReferenceId) {
        this.defaultVariantReferenceId = defaultVariantReferenceId;
    }

    public ProductConfiguration type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Option type. Indicates the product type the option can be assigned to. -
     * &#x60;CONFIGURABLE&#x60;: Configurable product option - &#x60;SWATCH&#x60;: Swatch product
     * option. Must be used for color or text swatches attributes
     *
     * @return type
     */
    @javax.annotation.Nonnull
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public ProductConfiguration values(List<ProductOptionValue> values) {
        this.values = values;
        return this;
    }

    public ProductConfiguration addValuesItem(ProductOptionValue valuesItem) {
        if (this.values == null) {
            this.values = new ArrayList<>();
        }
        this.values.add(valuesItem);
        return this;
    }

    /**
     * A list of option values. Defines option values available to shoppers (for example,
     * \&quot;red\&quot; color or \&quot;large\&quot; size).
     *
     * @return values
     */
    @javax.annotation.Nonnull
    public List<ProductOptionValue> getValues() {
        return values;
    }

    public void setValues(List<ProductOptionValue> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductConfiguration productConfiguration = (ProductConfiguration) o;
        return Objects.equals(this.attributeCode, productConfiguration.attributeCode)
                && Objects.equals(this.label, productConfiguration.label)
                && Objects.equals(
                        this.defaultVariantReferenceId,
                        productConfiguration.defaultVariantReferenceId)
                && Objects.equals(this.type, productConfiguration.type)
                && Objects.equals(this.values, productConfiguration.values);
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
        return Objects.hash(attributeCode, label, defaultVariantReferenceId, type, values);
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
        sb.append("class ProductConfiguration {\n");
        sb.append("    attributeCode: ").append(toIndentedString(attributeCode)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    defaultVariantReferenceId: ")
                .append(toIndentedString(defaultVariantReferenceId))
                .append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
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
        openapiFields.add("attributeCode");
        openapiFields.add("label");
        openapiFields.add("defaultVariantReferenceId");
        openapiFields.add("type");
        openapiFields.add("values");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("attributeCode");
        openapiRequiredFields.add("type");
        openapiRequiredFields.add("values");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ProductConfiguration
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ProductConfiguration.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in ProductConfiguration is not found in the empty JSON string",
                                ProductConfiguration.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ProductConfiguration.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `ProductConfiguration` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ProductConfiguration.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                        String.format(
                                "The required field `%s` is not found in the JSON string: %s",
                                requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("attributeCode").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `attributeCode` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("attributeCode").toString()));
        }
        if ((jsonObj.get("label") != null && !jsonObj.get("label").isJsonNull())
                && !jsonObj.get("label").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `label` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("label").toString()));
        }
        if ((jsonObj.get("defaultVariantReferenceId") != null
                        && !jsonObj.get("defaultVariantReferenceId").isJsonNull())
                && !jsonObj.get("defaultVariantReferenceId").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `defaultVariantReferenceId` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("defaultVariantReferenceId").toString()));
        }
        if (!jsonObj.get("type").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `type` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("type").toString()));
        }
        // validate the required field `type`
        TypeEnum.validateJsonElement(jsonObj.get("type"));
        // ensure the json data is an array
        if (!jsonObj.get("values").isJsonArray()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `values` to be an array in the JSON string but got `%s`",
                            jsonObj.get("values").toString()));
        }

        JsonArray jsonArrayvalues = jsonObj.getAsJsonArray("values");
        // validate the required field `values` (array)
        for (int i = 0; i < jsonArrayvalues.size(); i++) {
            ProductOptionValue.validateJsonElement(jsonArrayvalues.get(i));
        }
        ;
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ProductConfiguration.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ProductConfiguration' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ProductConfiguration> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(ProductConfiguration.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<ProductConfiguration>() {
                        @Override
                        public void write(JsonWriter out, ProductConfiguration value)
                                throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public ProductConfiguration read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of ProductConfiguration given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProductConfiguration
     * @throws IOException if the JSON string is invalid with respect to ProductConfiguration
     */
    public static ProductConfiguration fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ProductConfiguration.class);
    }

    /**
     * Convert an instance of ProductConfiguration to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
