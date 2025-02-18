package com.ccg.cuecardgenerator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ccgService {
    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String GeminiApiUrl;
    @Value("${gemini.api.key}")
    private String GeminiAPiKey;


    public ccgService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public String getCard() {
        String prompt = "\"Generate a unique IELTS-style cue card with a new, non-repeating topic. The topic must be meaningful and different from previous ones. Format it exactly as shown below without answering it. The structure must remain consistent.\n" +
                "\n" +
                "Example Format:\n" +
                "\n" +
                "[Topic]\n" +
                "Describe [topic].\n" +
                "You should say:\n" +
                "\n" +
                "[First prompt]\n" +
                "[Second prompt]\n" +
                "[Third prompt]\n" +
                "And explain [final prompt].\n" +
                "Use this example for reference:\n" +
                "\n" +
                "A Person You Admire\n" +
                "\n" +
                "Describe a person you admire.\n" +
                "\n" +
                "You should say:\n" +
                "\n" +
                "- Who is this person?\n" +
                "- What do they do?\n" +
                "- What qualities do you admire about them?\n" +
                "\n" +
                "And explain why you respect this person so much.\"\n" +
                "Do not modify the structure or add unnecessary details. Ensure the output follows this format exactly.\"";
        //build request
        Map<String, Object> requestBody = Map.of(
                "contents", Map.of(
                        "parts", Map.of(
                                "text", prompt
                        )
                )
        );
        //hit the request and receive the response
        String response = webClient.post()
                .uri(GeminiApiUrl + GeminiAPiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return ExtractResponseContent(response);
    }

    private String ExtractResponseContent(String response) {
        try {
            ObjectMapper ob = new ObjectMapper();
            JsonNode rootNode = ob.readTree(response);
            JsonNode candidatesNode = rootNode.path("candidates");
            if (candidatesNode.isArray() && candidatesNode.size() > 0) {
                JsonNode contentNode = candidatesNode.get(0).path("content");
                JsonNode partsNode = contentNode.path("parts");
                if (partsNode.isArray() && partsNode.size() > 0) {
                    return partsNode.get(0).path("text").asText();
                }
            }
            return "";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}