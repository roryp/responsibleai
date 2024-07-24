# Log in to Azure
az login

# Set the resource group name
RESOURCE_GROUP="openaieastusrpza"
IDENTITY_NAME="rpopenaieastusrpza"

# Create a user-assigned managed identity
az identity create --name $IDENTITY_NAME --resource-group $RESOURCE_GROUP

# Get the client ID and principal ID of the managed identity
CLIENT_ID=$(az identity show --name $IDENTITY_NAME --resource-group $RESOURCE_GROUP --query 'clientId' --output tsv)
PRINCIPAL_ID=$(az identity show --name $IDENTITY_NAME --resource-group $RESOURCE_GROUP --query 'principalId' --output tsv)

echo "Managed Identity Created:"
echo "Client ID: $CLIENT_ID"
echo "Principal ID: $PRINCIPAL_ID"
