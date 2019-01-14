package com.bigdata.topic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiCoreResponse {
    private List<ApiCoreData> data;

    public ApiCoreResponse() {
    }

    public ApiCoreResponse(List<ApiCoreData> data) {
        this.data = data;
    }

    public List<ApiCoreData> getData() {
        return data;
    }

    public void setData(List<ApiCoreData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiCoreResponse{" +
                "data=" + data +
                '}';
    }
}
