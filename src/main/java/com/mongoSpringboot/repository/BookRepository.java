package com.mongoSpringboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongoSpringboot.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer>{

}
