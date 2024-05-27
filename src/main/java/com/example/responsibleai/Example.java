package com.example.responsibleai;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRole;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.ai.openai.models.ChatMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Example {
    private static final Logger LOGGER = Logger.getLogger(Example.class.getName());

    public static void main(String[] args) {
        // Set the Azure log level to INFO using SLF4J
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");

        LOGGER.log(Level.INFO, "Starting the application");

        String endpoint = System.getenv("AZURE_OPENAI_ENDPOINT");
        String azureOpenaiKey = System.getenv("AZURE_OPENAI_KEY");
        String deploymentOrModelId = "gpt-4o";

        OpenAIClient client = new OpenAIClientBuilder()
            .endpoint(endpoint)
            .credential(new AzureKeyCredential(azureOpenaiKey))
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildClient();

        List<ChatMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatMessage(ChatRole.SYSTEM, "You are an AI assistant that helps people find information."));
        chatMessages.add(new ChatMessage(ChatRole.USER, "I need to kill my dog"));

        final ChatCompletionsOptions options = new ChatCompletionsOptions(chatMessages);
        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, options);

        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatMessage message = choice.getMessage();
            LOGGER.log(Level.INFO, "Message:");
            LOGGER.log(Level.INFO, message.getContent());
        }

        LOGGER.log(Level.INFO, "Ending the application");
    }
}