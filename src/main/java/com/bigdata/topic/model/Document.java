package com.bigdata.topic.model;

import java.util.List;

public class Document {
    private String category;
    private String title;
    private String url;

    public Document(String title,  String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
