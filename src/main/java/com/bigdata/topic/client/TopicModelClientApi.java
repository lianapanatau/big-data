package com.bigdata.topic.client;

import com.bigdata.topic.http.RequestBuilder;
import com.bigdata.topic.model.TopicResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@Component
public class TopicModelClientApi {

    @Autowired
    private RestTemplate restTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public Map<String, TopicResponse> getTopics(String file) {
        ResponseEntity<String> responseEntity = RequestBuilder
                .prepareCall("http://localhost:8081/topic")
                .withPostMethod()
                .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
                .withBody(file)
                .acceptJson()
                .makeCall(restTemplate, String.class);

        try {
            return objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, TopicResponse>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
