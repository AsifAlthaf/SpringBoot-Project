package com.codepsace.FreshMart;

public class ResponseGenerator {
    public String generateResponse() {
        // Directly create and use ChatGPTService
        ChatGPTService model = new ChatGPTService();
        return model.generate();  // return the response string
    }
}