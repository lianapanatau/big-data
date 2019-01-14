package com.bigdata.topic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

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
            result = new BufferedReader(new InputStreamReader(file.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
