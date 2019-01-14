package com.bigdata.topic.controller;

import com.itextpdf.text.pdf.PdfReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@RestController("topic-modeling")
public class DocumentsController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @PostMapping("/upload")
    public void fileReceiver(@RequestParam("file") MultipartFile file) {
        String result = "";
        try {
            PdfReader pdfReader = new PdfReader(file.getInputStream());
            System.out.println(pdfReader.getNumberOfPages());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
