package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.miniBook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface miniBookRepo extends MongoRepository<miniBook,Integer> {
}
