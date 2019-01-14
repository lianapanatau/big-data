package com.bigdata.topic.client;

import com.bigdata.topic.model.ApiCoreData;
import com.bigdata.topic.model.ApiCoreResponse;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toMap;

@Component
public class CoreApiClient {

    private static List<String> TOPIC_LIST = asList("health", "science", "Astronomy",
            "electronics", "Gastronomy", "Physics", "Biology", "Sport", "technology");
    private static String apiCoreSearchUrl = "https://core.ac.uk:443/api-v2/articles/search/";

    private RestTemplate restTemplate = new RestTemplate();

    public Map<String, Set<ApiCoreData>> collectDocumentsUrlBasedOnTopicList() {
        return TOPIC_LIST
                .stream()
                .map(topic ->
                {
                    String url = apiCoreSearchUrl + topic + "?apiKey=20hIsS1F5j4D2C2iXrg4Wxf7VTp4Xt1j";
                    ResponseEntity<ApiCoreResponse> responseEntity = restTemplate.getForEntity(url, ApiCoreResponse.class);
                    return new AbstractMap.SimpleImmutableEntry<String, ResponseEntity<ApiCoreResponse>>(topic, responseEntity);
                })
                .filter(entry -> entry.getValue().getStatusCode() == HttpStatus.OK)
                .map(entry ->
                        {
                            Set<ApiCoreData> urls = Optional
                                    .ofNullable(entry.getValue().getBody())
                                    .map(ApiCoreResponse::getData)
                                    .filter(CollectionUtils::isNotEmpty)
                                    .orElse(Collections.emptyList())
                                    .stream()
                                    .limit(20)
                                    .collect(Collectors.toSet());
                            return new AbstractMap.SimpleImmutableEntry<String, Set<ApiCoreData>>(entry.getKey(), urls);
                        }
                )
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
