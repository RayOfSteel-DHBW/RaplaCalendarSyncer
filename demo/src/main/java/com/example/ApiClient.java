package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Responsible for fetching the raw JSON data from the given API endpoint,
 * and parsing it into EventItem[] objects.
 */
public class ApiClient {
    private final String endpoint;
    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    /**
     * Constructor takes the endpoint URL as a parameter,
     * allowing flexibility to change endpoints without changing the code elsewhere.
     */
    public ApiClient(String endpoint) {
        this.endpoint = endpoint;
        this.httpClient = HttpClient.newHttpClient();
        this.mapper = new ObjectMapper(); 
        // ObjectMapper is used to convert JSON into our EventItem objects.
    }

    /**
     * Fetch events from the API endpoint and return them as an array.
     * In a real-world scenario, you'd add error handling, retries, and logging here.
     */
    public EventItem[] getEvents() {
        try {
            // Build a simple GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Convert JSON into EventItem[] using the ObjectMapper
            return mapper.readValue(json, EventItem[].class);

        } catch (Exception e) {
            // In a more robust application, this exception would be logged and possibly rethrown.
            // For now, we just print the stack trace and return an empty array.
            e.printStackTrace();
            return new EventItem[0];
        }
    }
}
