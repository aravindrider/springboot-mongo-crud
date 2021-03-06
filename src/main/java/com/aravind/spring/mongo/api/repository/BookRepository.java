package com.aravind.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aravind.spring.mongo.api.model.Book;

@Repository("repository")
public interface BookRepository extends MongoRepository<Book,Integer>{

}
