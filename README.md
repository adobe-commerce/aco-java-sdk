# Adobe Commerce Optimizer Java SDK

The Adobe Commerce Optimizer (ACO) Java SDK provides an easy integration point with the Adobe Commerce Optimizer Data Ingestion API. With the ACO SDK, you do not need to manage the full integration with catalog ingestion APIs and IMS authentication methods. Simply follow the guide below to install and begin using the ACO client SDK directly in your Java project.

For complete Merchandising Services documentation, visit the [Adobe Developer Documentation](https://developer-stage.adobe.com/commerce/services/composable-catalog/) site.

## Requirements

- Java 11+
- Maven 3.6+

## Build the SDK

To generate the SDK from the OpenAPI spec using the Maven plugin:

```bash
mvn clean install
```

This will:

- Download the latest OpenAPI spec file.
- Generate SDK classes using custom Mustache templates.
- Format the generated Java code using Spotless and google-java-format.

## Initialize the SDK

To start ingesting your catalog into Adobe Commerce Optimizer, you need to create a client using `ClientBuilder`. The builder requires a configuration object of type `ClientConfig`. This object requires the following:

Environment variables must be set with the corresponding values:

- `IMS_CLIENT_ID`: This is your client id found in the Adobe Developer Console.
- `IMS_CLIENT_SECRET`: This is your client secret found in the Adobe Developer Console.
- `TENANT_ID`: This is the identifier for your ACO instance.
- `REGION`: This is the region in which your ACO instance is deployed. Example: `na1`.
- `ENVIRONMENT`: This is your ACO instance's environment type: `sandbox` or `production`.

### How do I find my configuration values?

In the [Commerce Cloud Manager](https://experience.adobe.com/#/@commerceprojectbeacon/commerce/cloud-service/instances), you will see a list of all of the instances you have provisioned. Find the instance you want to point the ACO SDK to and click the "Instance info" icon. In the popup, find the `GraphQL endpoint` URL. From this URL, we can determine the required `tenantId`, `region`, and `environment` configuration variables.

The URL is composed of the following: `https://{region}[-sandbox].api.commerce.adobe.com/{tenantId}/graphql`

As an example:

- Sandbox: `https://na1-sandbox.api.commerce.adobe.com/WVYj1WZf8ifzLH7n6WAVas/graphql`
- Production: `https://na1.api.commerce.adobe.com/WVYj1WZf8ifzLH7n6WAVas/graphql`

From the above examples:

- `tenantId`: `WVYj1WZf8ifzLH7n6WAVas`
- `region`: `na1`
- `environment`: `sandbox` or `production` (depending on the URL)

### Example

```java
AdobeCredentials credentials = new AdobeCredentials(
    System.getenv("IMS_CLIENT_ID"),
    System.getenv("IMS_CLIENT_SECRET")
);

ClientConfig config = new ClientConfig(
    credentials,
    System.getenv("TENANT_ID"),
    Region.fromValue(System.getenv("REGION")),
    Environment.fromValue(System.getenv("ENVIRONMENT"))
);

Client client = ClientBuilder.createClient(config);
```

Once the client is initialized, you can begin ingesting your catalog data into Adobe Commerce Optimizer.

## Ingest Catalog Data

The ACO SDK Client provides methods to easily manage the following catalog entities:

- Products
- Product Metadata
- Price Books
- Prices

All operations are synchronous. For example:

### Create Products

```java
FeedProduct product1 = new FeedProduct();
product1.setSku("EXAMPLE-SKU-001");
product1.setScope(new Scope("en-US"));
product1.setName("Example Product 1");
product1.setSlug("example-product-1");
product1.setDescription("This is an example product created via the SDK");
product1.setStatus(FeedProduct.StatusEnum.ENABLED);
product1.setVisibleIn(List.of(FeedProduct.VisibleInEnum.CATALOG, FeedProduct.VisibleInEnum.SEARCH));
ProductAttribute attr1 = new ProductAttribute();
attr1.setCode("brand");
attr1.setType(ProductAttribute.TypeEnum.STRING);
attr1.setValues(List.of("Example Brand"));
product1.setAttributes(List.of(attr1));

FeedProduct product2 = new FeedProduct();
product2.setSku("EXAMPLE-SKU-002");
product2.setScope(new Scope("en-US"));
product2.setName("Example Product 2");
product2.setSlug("example-product-2");
product2.setDescription("This is another example product created via the SDK");
product2.setStatus(FeedProduct.StatusEnum.ENABLED);
product2.setVisibleIn(List.of(FeedProduct.VisibleInEnum.CATALOG, FeedProduct.VisibleInEnum.SEARCH));
ProductAttribute attr2 = new ProductAttribute();
attr2.setCode("brand");
attr2.setType(ProductAttribute.TypeEnum.STRING);
attr2.setValues(List.of("Example Brand"));
product2.setAttributes(List.of(attr2));

ProcessFeedResponse response = client.createProductsSync(List.of(product1, product2));
System.out.println(response);
```

### Update Products

```java
FeedProductUpdate update = new FeedProductUpdate();
update.setSku("EXAMPLE-SKU-001");
update.setScope(new Scope("en-US"));
update.setName("Updated Product Name");

ProcessFeedResponse response = client.updateProductsSync(List.of(update));
System.out.println(response);
```

### Delete Products

```java
FeedProductDelete delete = new FeedProductDelete();
delete.setSku("EXAMPLE-SKU-001");
delete.setScope(new Scope("en-US"));

ProcessFeedResponse response = client.deleteProductsSync(List.of(delete));
System.out.println(response);
```

### Create Product Metadata

```java
FeedMetadata metadata = new FeedMetadata();
metadata.setCode("color");
metadata.setScope(new Scope("en-US"));
metadata.setLabel("Color");
metadata.setDataType(FeedMetadata.DataTypeEnum.TEXT);
metadata.setVisibleIn(List.of(FeedMetadata.VisibleInEnum.PRODUCT_DETAIL));
metadata.setFilterable(true);
metadata.setSortable(true);
metadata.setSearchable(true);

ProcessFeedResponse response = client.createProductMetadataSync(List.of(metadata));
System.out.println(response);
```

### Update Product Metadata

```java
FeedMetadataUpdate metadataUpdate = new FeedMetadataUpdate();
metadataUpdate.setCode("color");
metadataUpdate.setScope(new Scope("en-US"));
metadataUpdate.setLabel("Updated Color Label");

ProcessFeedResponse response = client.updateProductMetadataSync(List.of(metadataUpdate));
System.out.println(response);
```

### Delete Product Metadata

```java
FeedMetadataDelete metadataDelete = new FeedMetadataDelete();
metadataDelete.setCode("color");
metadataDelete.setScope(new Scope("en-US"));

ProcessFeedResponse response = client.deleteProductMetadataSync(List.of(metadataDelete));
System.out.println(response);
```

### Create Price Books

```java
FeedPricebook pricebook = new FeedPricebook();
pricebook.setPriceBookId("default");
pricebook.setName("Default Price Book");
pricebook.setCurrency("USD");

ProcessFeedResponse response = client.createPriceBooksSync(List.of(pricebook));
System.out.println(response);
```

### Update Price Books

```java
FeedPricebook pricebookUpdate = new FeedPricebook();
pricebookUpdate.setPriceBookId("default");
pricebookUpdate.setName("Updated Price Book Name");

ProcessFeedResponse response = client.updatePriceBooksSync(List.of(pricebookUpdate));
System.out.println(response);
```

### Delete Price Books

```java
FeedPricebook pricebookDelete = new FeedPricebook();
pricebookDelete.setPriceBookId("default");

ProcessFeedResponse response = client.deletePriceBooksSync(List.of(pricebookDelete));
System.out.println(response);
```

### Create Prices

```java
FeedPrices price = new FeedPrices();
price.setSku("EXAMPLE-SKU-001");
price.setPriceBookId("default");
price.setRegular(99.99);

ProcessFeedResponse response = client.createPricesSync(List.of(price));
System.out.println(response);
```

### Update Prices

```java
FeedPricesUpdate priceUpdate = new FeedPricesUpdate();
priceUpdate.setSku("EXAMPLE-SKU-001");
priceUpdate.setPriceBookId("default");
priceUpdate.setRegular(99.99);

ProcessFeedResponse response = client.updatePricesSync(List.of(priceUpdate));
System.out.println(response);
```

### Delete Prices

```java
FeedPricesDelete priceDelete = new FeedPricesDelete();
priceDelete.setSku("EXAMPLE-SKU-001");
priceDelete.setPriceBookId("default");

ProcessFeedResponse response = client.deletePricesSync(List.of(priceDelete));
System.out.println(response);
```

## Development Notes

### Generating SDK from OpenAPI spec

The SDK uses a custom `generator-config.yaml` file and Mustache templates stored in the `generator/templates` directory. The OpenAPI generator Maven plugin uses these to produce the classes inside `src/main/java`.

To modify generated classes:

- Edit the Mustache templates.
- Run `mvn clean install` to regenerate the SDK code.

## Code Generation Notice

This SDK includes **autogenerated code** based on the Adobe Commerce Optimizer OpenAPI specification.

To improve usability, all generated classes (models, API interface, and implementation) are **already committed** to this repository. This allows you to clone and start using the SDK immediately without needing to run a generation step.

If you want to **regenerate the SDK code** (e.g., after updating the OpenAPI spec or custom templates), you can do so using Maven:

```bash
mvn clean install
```

> 📌 **Important:**
> - Do **not manually edit** any of the generated files.
> - Custom templates are located in `generator/templates`.
> - Configuration for code generation is found in `generator/generator-config.yaml`.
> - To ignore specific files from generation, use the `.openapi-generator-ignore` file.

If you prefer to manage your own generation flow, you can delete the generated files and use `mvn openapi-generator:generate` directly.

### Formatting Code

All Java code is formatted automatically using Spotless and `google-java-format` via the Maven plugin.

To apply formatting manually:

```bash
mvn spotless:apply
```

## License

This project is licensed under the terms of the Adobe License.
