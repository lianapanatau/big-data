package com.bigdata.topic.controller;

import com.bigdata.topic.model.Document;
import com.bigdata.topic.model.TopicModelResponse;
import com.bigdata.topic.service.DocumentService;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

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
    public List<Map<String, Object>> fileReceiver(@RequestParam("file") MultipartFile file) {
        try {
            InputStream inputStream =  new BufferedInputStream(file.getInputStream());
            String fileAsString = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
            TopicModelResponse topicsForArticle = documentService.getTopicsForArticle(fileAsString);

        } catch (IOException e) {
            System.out.println("EROARE");
            //e.printStackTrace();
        }
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        List<Map<String, Object>> lista = new ArrayList<>();
        TOPIC_LIST.forEach(t -> {
            Map<String, Object> match = new HashMap<>();
            double val = random.nextGaussian();
            match.put("category", t);
            match.put("topics", Arrays.asList("ceva", " keva"));
            match.put("similarity", val);
            lista.add(match);
        });
        return lista;
    }
}
