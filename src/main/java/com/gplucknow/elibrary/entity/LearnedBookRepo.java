package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Learnedbook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LearnedBookRepo extends MongoRepository<Learnedbook,Integer> {
}
