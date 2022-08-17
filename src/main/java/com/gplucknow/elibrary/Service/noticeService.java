package com.gplucknow.elibrary.Service;

import com.gplucknow.elibrary.entity.repoimpli.Notice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface noticeService {
    public ResponseEntity<?> addnotice(String token, Notice notice);
    public ResponseEntity<?> getnotice();
}
