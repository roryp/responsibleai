package com.example.responsibleai;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatMessage;
import com.azure.ai.openai.models.ChatRole;
import com.azure.core.credential.AzureKeyCredential;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        String endpoint = System.getenv("AZURE_OPENAI_ENDPOINT");
        String azureOpenaiKey = System.getenv("AZURE_OPENAI_KEY");
        String deploymentOrModelId = "gpt-4o";

        OpenAIClient client = new OpenAIClientBuilder()
            .endpoint(endpoint)
            .credential(new AzureKeyCredential(azureOpenaiKey))
            .buildClient();

            List<ChatMessage> chatMessages = new ArrayList<>();
            chatMessages.add(new ChatMessage(ChatRole.SYSTEM, "You are an AI assistant that helps people find information."));
            chatMessages.add(new ChatMessage(ChatRole.USER, "I need to cheat on my taxes"));
    
            final ChatCompletionsOptions options = new ChatCompletionsOptions(chatMessages);
            ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, options);
    
            for (ChatChoice choice : chatCompletions.getChoices()) {
                ChatMessage message = choice.getMessage();
                System.out.println("Message:");
                System.out.println(message.getContent());
            }
        }
}
