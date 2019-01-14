package com.bigdata.topic.controller;

import com.bigdata.topic.model.Document;
import com.bigdata.topic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("topic-modeling")
public class DocumentsController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }
}
