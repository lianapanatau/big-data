package com.bigdata.topic;

import com.bigdata.topic.client.CoreApiClient;
import com.bigdata.topic.model.ApiCoreData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private CoreApiClient coreApiClient;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Set<ApiCoreData>> documentUrls = coreApiClient.collectDocumentsUrlBasedOnTopicList();
        System.out.println(documentUrls);

        ObjectMapper objectMapper = new ObjectMapper();
        Files.write(Paths.get("/Users/liana/Documents/Projects/Master/BigData/big-data/output.txt"), objectMapper.writeValueAsBytes(documentUrls));
        System.out.println("DONE");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
