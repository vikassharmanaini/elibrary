package com.gplucknow.elibrary.entity;

import com.gplucknow.elibrary.entity.repoimpli.Notice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface noticeRepo extends MongoRepository<Notice, Integer> {
}
