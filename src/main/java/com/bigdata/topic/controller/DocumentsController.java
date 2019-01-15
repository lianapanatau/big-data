package com.bigdata.topic.controller;

import com.bigdata.topic.model.Document;
import com.bigdata.topic.service.DocumentService;
import com.itextpdf.text.pdf.PdfReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.Arrays.asList;

@RestController("topic-modeling")
public class DocumentsController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    private static List<String> TOPIC_LIST = asList("health", "science", "astronomy",
            "electronics", "gastronomy", "physics", "biology", "sport", "technology");

    @PostMapping("/upload")
    public List<Map<String, Object>> fileReceiver(@RequestParam("file") MultipartFile file) {
        try {
            PdfReader pdfReader = new PdfReader(file.getInputStream());
            System.out.println(pdfReader.getNumberOfPages());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        List<Map<String, Object>> lista = new ArrayList<>();
        TOPIC_LIST.forEach(t -> {
            Map<String, Object> match = new HashMap<>();
            double val = random.nextGaussian();
            match.put("category", t);
            match.put("topics", Arrays.asList("ceva"," keva"));
            match.put("similarity", val);
            lista.add(match);
        });
        return lista;
    }
}
