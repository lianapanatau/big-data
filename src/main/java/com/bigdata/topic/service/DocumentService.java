package com.bigdata.topic.service;

import com.bigdata.topic.client.TopicModelClientApi;
import com.bigdata.topic.model.Document;
import com.bigdata.topic.model.TopicResponse;
import com.bigdata.topic.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TopicModelClientApi topicModelClientApi;


    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void saveDocuments(List<Document> documents) {
        documents.forEach(documentRepository::save);
    }

    public Map<String, TopicResponse> getTopicsForArticle(String file) {
        return topicModelClientApi.getTopics(file);
    }
}
