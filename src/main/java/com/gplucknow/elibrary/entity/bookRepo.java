package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookRepo extends MongoRepository<Book, Integer> {
}
