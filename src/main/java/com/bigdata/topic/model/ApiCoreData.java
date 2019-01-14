package com.bigdata.topic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiCoreData {
    private String downloadUrl;
    private String title;

    public ApiCoreData() {
    }

    public ApiCoreData(String downloadUrl, String title) {
        this.downloadUrl = downloadUrl;
        this.title = title;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ApiCoreData{" +
                "downloadUrl='" + downloadUrl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
