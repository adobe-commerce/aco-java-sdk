# Adobe Commerce Optimizer Java SDK

This SDK provides a Java client to interact with the Adobe Commerce Optimizer (ACO) Data Ingestion API. It is built using OpenAPI Generator and Maven for streamlined integration and customization.

## Project Structure

The project contains both **generated code** (from the OpenAPI specification) and **manually written logic** (for authentication, client handling, etc.).

```
.
├── README.md                           # Project documentation (manually written)
├── catalog-ingestion-openapi-spec.yaml # OpenAPI specification (downloaded or maintained)
├── generator/                          # Code generation configuration
│   ├── generator-config.yaml           # OpenAPI generator config (used by plugin)
│   ├── templates/                      # Mustache templates for SDK customization
│   │   ├── AdobeCredentials.mustache
│   │   ├── ClientBuilder.mustache
│   │   ├── ClientConfig.mustache
│   │   ├── Environment.mustache
│   │   ├── Region.mustache
│   │   ├── client.mustache
│   │   ├── clientImpl.mustache
│   │   └── licenseInfo.mustache
├── pom.xml                             # Maven build configuration
├── src/main/java/com/adobe/aco/
│   ├── auth/                           # Manual IMS authentication logic
│   ├── client/                         # Client interface/impl (generated via templates)
│   ├── error/                          # Custom error types (manual)
│   ├── http/                           # HTTP client layer (manual)
│   ├── model/                          # POJOs generated from OpenAPI spec
│   └── ClientExample.java              # Sample client usage (manual)
└── target/                             # Compiled classes and artifacts (Maven output)
```

## Generated Code

- All classes in `src/main/java/com/adobe/aco/model/` are generated from the OpenAPI spec.
- `Client.java` and `ClientImpl.java` are generated using custom Mustache templates from the `/generator/templates/` directory.
- The `openapi-generator-maven-plugin` handles the generation as part of the Maven lifecycle (`generate-sources`).

## Manually Maintained Code

- All content in `auth/`, `error/`, `http/`, and utility classes like `ClientBuilder` and `ClientConfig` are hand-written.
- Custom Mustache templates reside in `generator/templates/`.
- `pom.xml` and `generator-config.yaml` define the generation process and options.
- `.openapi-generator-ignore` excludes unwanted files like `ApiClient`, `Configuration`, and Gradle artifacts.

## Notes

- **Deprecated**: The `generate.sh` script was previously used to invoke OpenAPI CLI. This has been replaced by the Maven plugin.
- The OpenAPI spec is downloaded or maintained locally as `catalog-ingestion-openapi-spec.yaml`.