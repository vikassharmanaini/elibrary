package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo  extends MongoRepository<Student,Integer> {
    public Student findByEmail(String email);
    public Student findByEnroll(String enroll);
    public Student findByToken(String token);
}
