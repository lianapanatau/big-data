package com.bigdata.topic.controller;

import com.bigdata.topic.model.Document;
import com.bigdata.topic.model.TopicResponse;
import com.bigdata.topic.service.DocumentService;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@RestController("topic-modeling")
public class DocumentsController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    private static List<String> TOPIC_LIST = asList("health", "science", "astronomy",
            "electronics", "gastronomy", "physics", "biology", "sport", "technology");

    @PostMapping("/upload")
    public Map<String, TopicResponse> getCategoryForArticle(@RequestParam("file") MultipartFile pdf) {
        return documentService.getTopicsForArticle(getPdfAsString(pdf));
    }

    private String getPdfAsString(MultipartFile pdf) {
        PdfReader pdfReader = null;
        try {
            pdfReader = new PdfReader(pdf.getInputStream());
            PdfReaderContentParser parser = new PdfReaderContentParser(pdfReader);
            TextExtractionStrategy strategy;
            StringBuilder fileAsString = new StringBuilder();
            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                fileAsString.append(strategy.getResultantText());
            }
            pdfReader.close();

            return fileAsString.toString();
        } catch (IOException e) {
            System.out.println("Eroare");
        }
        return "";
    }
}
