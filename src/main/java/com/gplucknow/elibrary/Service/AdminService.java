package com.gplucknow.elibrary.Service;

import com.gplucknow.elibrary.entity.repoimpli.Admin;
import com.gplucknow.elibrary.entity.repoimpli.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public ResponseEntity<?> signUp(Admin admin);
    public ResponseEntity<?> logIn(String email,String password);
    public ResponseEntity<?> auth(String token);
    public boolean logout(String token);
    public ResponseEntity<?> addNewBook(Book book,String token);
    public ResponseEntity<?> topBooks();
    public ResponseEntity<?> topStudent();

}
