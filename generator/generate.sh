#!/bin/bash

# Config
FORCE=false
GEN_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
SPEC_FILE_URL="https://raw.githubusercontent.com/AdobeDocs/commerce-services/refs/heads/develop/src/openapi/data-ingestion-schema-v1.yaml"
TEMP_SPEC="catalog-ingestion-openapi-spec.yaml.tmp"
CURRENT_SPEC="catalog-ingestion-openapi-spec.yaml"

cd "$GEN_DIR" || exit 1

# Parse CLI arguments
while [[ "$#" -gt 0 ]]; do
    case $1 in
        -f|--force) FORCE=true ;;
        *) echo "Unknown parameter: $1"; exit 1 ;;
    esac
    shift
done

echo "########################"
echo "Generating ACO Java SDK"
echo "########################"

# Step 1: Download latest OpenAPI spec
echo -e "\n📥 Downloading latest OpenAPI spec from: $SPEC_FILE_URL"
curl -s -o "$TEMP_SPEC" "$SPEC_FILE_URL"

# Step 2: Skip generation if no changes (unless forced)
if [ "$FORCE" = false ] && [ -f "$CURRENT_SPEC" ] && cmp -s "$TEMP_SPEC" "$CURRENT_SPEC"; then
    echo -e "\n⚠️ No changes detected in OpenAPI spec. Skipping generation."
    rm "$TEMP_SPEC"
    exit 0
fi

# Overwrite the current spec with the new one
mv "$TEMP_SPEC" "$CURRENT_SPEC"

# Step 5: Run OpenAPI Generator
echo -e "\n🚀 Generating Java SDK code..."
openapi-generator generate \
  -c "$(pwd)/generator-config.yaml" \
  -i "$(pwd)/$CURRENT_SPEC" \
  -g java \
  -t templates \
  -o ../

#  --global-property=debugModels=true,models \
#  -o output-debug-test


#  -t templates \
#  -o ../
# --global-property debugModels=true,models \

# Step 6: Format the generated code
echo "⏳ Formateando archivos Java..."
find ../src/main/java -name "*.java" | xargs google-java-format -i
echo "✅ Formateo completado."

# Step 7: Done!
echo -e "\n✅ SDK generation completed!"
