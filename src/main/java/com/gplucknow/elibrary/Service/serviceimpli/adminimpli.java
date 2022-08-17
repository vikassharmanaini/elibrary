package com.gplucknow.elibrary.Service.serviceimpli;

import com.gplucknow.elibrary.Service.AdminService;
import com.gplucknow.elibrary.entity.AdminRepo;
import com.gplucknow.elibrary.entity.bookRepo;
import com.gplucknow.elibrary.entity.miniBookRepo;
import com.gplucknow.elibrary.entity.repoimpli.Admin;
import com.gplucknow.elibrary.entity.repoimpli.Book;
import com.gplucknow.elibrary.entity.repoimpli.miniBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
@Service
public class adminimpli implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private bookRepo bookRepo;
    @Autowired
    private miniBookRepo miniBookRepo;
    @Override
    public ResponseEntity<?> signUp(Admin admin) {
        Supplier<String> tokenSupplier =()->{
            StringBuilder token=new StringBuilder();
            long current= Instant.now().toEpochMilli();
            return token.append(current).append("-").append(UUID.randomUUID().toString()).toString();
        };
        try{
            admin.setId((admin.getEnroll()+admin.getEmail()).hashCode());
            if(adminRepo.findByEmail(admin.getEmail()).isEmpty() && adminRepo.findByEnroll(admin.getEnroll()).isEmpty()) {
                admin.setToken(tokenSupplier.get());
                adminRepo.insert(admin);
                return ResponseEntity.ok(admin.getToken());
            }else{
                return ResponseEntity.badRequest().body("Duplicate Request");
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }

    @Override
    public ResponseEntity<?> logIn(String email, String password) {
        Supplier<String> tokenSupplier =()->{
            StringBuilder token=new StringBuilder();
            long current= Instant.now().toEpochMilli();
            return token.append(current).append("-").append(UUID.randomUUID().toString()).toString();
        };
        List<Admin> adminList=adminRepo.findByEmail(email);
        if(adminList.size()==1){
            if (adminList.get(0).getPassword().equals(password)){
                adminList.get(0).setToken(tokenSupplier.get());
                adminRepo.save(adminList.get(0));
                return ResponseEntity.ok(adminList.get(0).getToken());
            }else return ResponseEntity.badRequest().body("incorrect password");
        }else{
            return ResponseEntity.badRequest().body(email+ " Not Found");
        }
    }

    @Override
    public ResponseEntity<?> auth(String token) {
        try{
            return ResponseEntity.ok(adminRepo.findByToken(token).get(0));
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @Override
    public boolean logout(String token) {
        List<Admin> adminList=adminRepo.findByToken(token);
        if(adminList.size()==1){
            adminList.get(0).setToken(null);
        }
        return true;
    }
    @Override
    public ResponseEntity<?> addNewBook(Book book, String token) {
        if(book.getName()!=null && book.getImgsrc()!=null && book.getPublication()!=null && book.getTags()!=null) {
            book.setId(book.getImgsrc().hashCode());
            bookRepo.insert(book);
            miniBook miniBook=new miniBook(book.getId(), book.getName(),book.getImgsrc(),book.getTags(),0);
            miniBookRepo.insert(miniBook);
            return ResponseEntity.ok(miniBook);
        }
            return ResponseEntity.badRequest().body("cannot created");
    }

    @Override
    public ResponseEntity<?> topBooks() {
        return null;
    }

    @Override
    public ResponseEntity<?> topStudent() {
        return null;
    }
}
