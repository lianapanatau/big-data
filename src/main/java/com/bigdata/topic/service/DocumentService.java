package com.bigdata.topic.service;

import com.bigdata.topic.model.Document;
import com.bigdata.topic.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void saveDocuments(List<Document> documents) {
        documents.forEach(documentRepository::save);
    }
}
