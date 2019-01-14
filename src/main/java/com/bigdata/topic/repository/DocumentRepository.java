package com.bigdata.topic.repository;


import com.bigdata.topic.model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Document, String> {

}
