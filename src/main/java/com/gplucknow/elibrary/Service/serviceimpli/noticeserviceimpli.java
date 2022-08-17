package com.gplucknow.elibrary.Service.serviceimpli;

import com.gplucknow.elibrary.Service.noticeService;
import com.gplucknow.elibrary.entity.AdminRepo;
import com.gplucknow.elibrary.entity.noticeRepo;
import com.gplucknow.elibrary.entity.repoimpli.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class noticeserviceimpli implements noticeService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    noticeRepo noticeRepo;
    @Override
    public ResponseEntity<?> addnotice(String token, Notice notice) {
        if(adminRepo.findByToken(token).size()==1){
            notice.setDate(new Date().toString());
            notice.setId((notice.getTitle()+notice.getDate()).hashCode());
            noticeRepo.insert(notice);
            return ResponseEntity.ok("Notice added");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> getnotice() {
       return ResponseEntity.ok( noticeRepo.findAll());
    }
}
