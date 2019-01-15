package com.bigdata.topic;

import com.bigdata.topic.client.CoreApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private CoreApiClient coreApiClient;

    @Override
    public void run(String... args) throws Exception {
//        Map<String, Set<ApiCoreData>> documentUrls = coreApiClient.collectDocumentsUrlBasedOnTopicList();
//        System.out.println(documentUrls);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Files.write(Paths.get("/Users/liana/Documents/Projects/Master/BigData/big-data/output.txt"), objectMapper.writeValueAsBytes(documentUrls));
//        System.out.println("DONE");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
