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
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/** ProductImage */
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        comments = "Generator version: 7.4.0")
public class ProductImage {
    public static final String SERIALIZED_NAME_URL = "url";

    @SerializedName(SERIALIZED_NAME_URL)
    private String url;

    public static final String SERIALIZED_NAME_LABEL = "label";

    @SerializedName(SERIALIZED_NAME_LABEL)
    private String label;

    /** Gets or Sets roles */
    @JsonAdapter(RolesEnum.Adapter.class)
    public enum RolesEnum {
        BASE("BASE"),

        SMALL("SMALL"),

        THUMBNAIL("THUMBNAIL"),

        SWATCH("SWATCH");

        private String value;

        RolesEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static RolesEnum fromValue(String value) {
            for (RolesEnum b : RolesEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<RolesEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final RolesEnum enumeration)
                    throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public RolesEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return RolesEnum.fromValue(value);
            }
        }

        public static void validateJsonElement(JsonElement jsonElement) throws IOException {
            String value = jsonElement.getAsString();
            RolesEnum.fromValue(value);
        }
    }

    public static final String SERIALIZED_NAME_ROLES = "roles";

    @SerializedName(SERIALIZED_NAME_ROLES)
    private List<RolesEnum> roles;

    public static final String SERIALIZED_NAME_CUSTOM_ROLES = "customRoles";

    @SerializedName(SERIALIZED_NAME_CUSTOM_ROLES)
    private List<String> customRoles;

    public ProductImage() {}

    public ProductImage url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Media resource URL
     *
     * @return url
     */
    @javax.annotation.Nonnull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductImage label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Media resource label
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

    public ProductImage roles(List<RolesEnum> roles) {
        this.roles = roles;
        return this;
    }

    public ProductImage addRolesItem(RolesEnum rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * Roles associated with this image that determine how the image is used on the storefront. -
     * &#x60;BASE&#x60;: Product image is visible as a main image on the Product Detail Page. -
     * &#x60;SMALL&#x60;: Product image is visible as a main image on the Category or search result
     * page or other product listing pages. - &#x60;THUMBNAIL&#x60;: Thumbnail images appear in the
     * thumbnail gallery, shopping cart, etc. - &#x60;SWATCH&#x60;: A swatch can be used to
     * illustrate the color, pattern, or texture.
     *
     * @return roles
     */
    @javax.annotation.Nullable
    public List<RolesEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEnum> roles) {
        this.roles = roles;
    }

    public ProductImage customRoles(List<String> customRoles) {
        this.customRoles = customRoles;
        return this;
    }

    public ProductImage addCustomRolesItem(String customRolesItem) {
        if (this.customRoles == null) {
            this.customRoles = new ArrayList<>();
        }
        this.customRoles.add(customRolesItem);
        return this;
    }

    /**
     * Custom image role. Merchants can define custom roles in addition to the predefined values.
     *
     * @return customRoles
     */
    @javax.annotation.Nullable
    public List<String> getCustomRoles() {
        return customRoles;
    }

    public void setCustomRoles(List<String> customRoles) {
        this.customRoles = customRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductImage productImage = (ProductImage) o;
        return Objects.equals(this.url, productImage.url)
                && Objects.equals(this.label, productImage.label)
                && Objects.equals(this.roles, productImage.roles)
                && Objects.equals(this.customRoles, productImage.customRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, label, roles, customRoles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProductImage {\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    customRoles: ").append(toIndentedString(customRoles)).append("\n");
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
        openapiFields.add("url");
        openapiFields.add("label");
        openapiFields.add("roles");
        openapiFields.add("customRoles");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("url");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ProductImage
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ProductImage.openapiRequiredFields
                    .isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                        String.format(
                                "The required field(s) %s in ProductImage is not found in the empty JSON string",
                                ProductImage.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ProductImage.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                        String.format(
                                "The field `%s` in the JSON string is not defined in the `ProductImage` properties. JSON: %s",
                                entry.getKey(), jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ProductImage.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                        String.format(
                                "The required field `%s` is not found in the JSON string: %s",
                                requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("url").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `url` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("url").toString()));
        }
        if ((jsonObj.get("label") != null && !jsonObj.get("label").isJsonNull())
                && !jsonObj.get("label").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `label` to be a primitive type in the JSON string but got `%s`",
                            jsonObj.get("label").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("roles") != null
                && !jsonObj.get("roles").isJsonNull()
                && !jsonObj.get("roles").isJsonArray()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `roles` to be an array in the JSON string but got `%s`",
                            jsonObj.get("roles").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("customRoles") != null
                && !jsonObj.get("customRoles").isJsonNull()
                && !jsonObj.get("customRoles").isJsonArray()) {
            throw new IllegalArgumentException(
                    String.format(
                            "Expected the field `customRoles` to be an array in the JSON string but got `%s`",
                            jsonObj.get("customRoles").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ProductImage.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ProductImage' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ProductImage> thisAdapter =
                    gson.getDelegateAdapter(this, TypeToken.get(ProductImage.class));

            return (TypeAdapter<T>)
                    new TypeAdapter<ProductImage>() {
                        @Override
                        public void write(JsonWriter out, ProductImage value) throws IOException {
                            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                            elementAdapter.write(out, obj);
                        }

                        @Override
                        public ProductImage read(JsonReader in) throws IOException {
                            JsonElement jsonElement = elementAdapter.read(in);
                            validateJsonElement(jsonElement);
                            return thisAdapter.fromJsonTree(jsonElement);
                        }
                    }.nullSafe();
        }
    }

    /**
     * Create an instance of ProductImage given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProductImage
     * @throws IOException if the JSON string is invalid with respect to ProductImage
     */
    public static ProductImage fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ProductImage.class);
    }

    /**
     * Convert an instance of ProductImage to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}
