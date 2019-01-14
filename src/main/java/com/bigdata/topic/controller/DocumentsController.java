package com.bigdata.topic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("topic-modeling")
public class DocumentsController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
