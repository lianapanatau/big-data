package com.bigdata.topic.model;

import java.util.List;

public class TopicResponse {
    private List<String> topics;
    private float similarity;
    private String cateogory;

    public TopicResponse() {
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public float getSimilarity() {
        return similarity;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }

    public String getCateogory() {
        return cateogory;
    }

    public void setCateogory(String cateogory) {
        this.cateogory = cateogory;
    }

    @Override
    public String toString() {
        return "TopicResponse{" +
                "topics=" + topics +
                ", similarity=" + similarity +
                ", cateogory='" + cateogory + '\'' +
                '}';
    }
}
