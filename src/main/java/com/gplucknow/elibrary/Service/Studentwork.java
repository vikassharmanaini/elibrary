package com.gplucknow.elibrary.Service;

import com.gplucknow.elibrary.entity.repoimpli.MiniStudent;
import com.gplucknow.elibrary.entity.repoimpli.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface Studentwork {
    public ResponseEntity<?> createStudent(Student student);
    public ResponseEntity<?> loginStudent(String email,String password);
    public ResponseEntity<?> loginStudentEN(String enroll,String password);
    public ResponseEntity<?> logout(String token);
    public boolean isLoggedIn(String token);
    public ResponseEntity<?> updateMe(Student student ,String token);
    public ResponseEntity<?> updateStudentValue(String token, MiniStudent miniStudent);
    public ResponseEntity<?> topStudent();
    public ResponseEntity<?> getminime(String token);
}
