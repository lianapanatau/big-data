package com.bigdata.topic.model;

import java.util.List;

public class TopicModelResponse {
    private List<TopicResponse> topicResponse;

    public List<TopicResponse> getTopicResponse() {
        return topicResponse;
    }

    public void setTopicResponse(List<TopicResponse> topicResponse) {
        this.topicResponse = topicResponse;
    }

    @Override
    public String toString() {
        return "TopicModelResponse{" +
                "topicResponse=" + topicResponse +
                '}';
    }
}
