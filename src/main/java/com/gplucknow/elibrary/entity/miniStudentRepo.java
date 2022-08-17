package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.MiniStudent;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface miniStudentRepo extends MongoRepository<MiniStudent,Integer> {
}
