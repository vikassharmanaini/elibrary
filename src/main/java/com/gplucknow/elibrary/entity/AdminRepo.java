package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AdminRepo extends MongoRepository<Admin,Integer> {
    public List<Admin> findByEmail(String email);
    public List<Admin> findByToken(String token);
    public List<Admin> findByEnroll(String enroll);
}
