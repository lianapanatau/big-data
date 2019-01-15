package com.bigdata.topic.model;

import java.util.Map;

public class TopicModelResponse {
    private Map<String, TopicResponse> topicResponse;

    public TopicModelResponse() {
    }

    public Map<String, TopicResponse> getTopicResponse() {
        return topicResponse;
    }

    public void setTopicResponse(Map<String, TopicResponse> topicResponse) {
        this.topicResponse = topicResponse;
    }

    @Override
    public String toString() {
        return "TopicModelResponse{" +
                "topicResponse=" + topicResponse +
                '}';
    }
}
