package com.bigdata.topic.model;

import java.util.List;

public class TopicResponse {
    private List<String> words;
    private float similarity;

    public TopicResponse() {
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public float getSimilarity() {
        return similarity;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }

    @Override
    public String toString() {
        return "TopicResponse{" +
                "words=" + words +
                ", similarity=" + similarity +
                '}';
    }
}
