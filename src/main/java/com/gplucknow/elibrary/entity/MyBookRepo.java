package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.mybook;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyBookRepo extends MongoRepository<mybook,Integer> {
    List<mybook> findByStudentId(Integer studentId);
}
