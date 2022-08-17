package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Bookmark;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookmarkRepo extends MongoRepository<Bookmark,Integer> {
    List<Bookmark> findByStudentId(Integer studentId);
}
