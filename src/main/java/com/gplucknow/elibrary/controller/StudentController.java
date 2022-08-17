package com.gplucknow.elibrary.controller;

import com.gplucknow.elibrary.Service.Studentwork;
import com.gplucknow.elibrary.entity.repoimpli.MiniStudent;
import com.gplucknow.elibrary.entity.repoimpli.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    @Autowired
    Studentwork studentwork;
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signupStudent(@RequestBody Student student){
        if (student.getPassword()!=null && student.getEnroll()!=null && student.getProfileimg()!=null && student.getBranch()!=null && student.getEmail()!=null && student.getName()!=null)
            return this.studentwork.createStudent(student);
        else
            return ResponseEntity.badRequest().body("no null");
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginStudent(@RequestBody Student student) {
        if (student.getEmail()!=null && student.getPassword()!=null)
            return this.studentwork.loginStudent(student.getEmail(), student.getPassword());
        else if (student.getEnroll()!=null && student.getPassword()!=null)
            return this.studentwork.loginStudentEN(student.getEnroll(),student.getPassword());
        else return ResponseEntity.badRequest().body("email and password is null");
    }
    @GetMapping(path = "/auth")
    public boolean authme(@RequestHeader String token){
        return this.studentwork.isLoggedIn(token);
    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateme(@RequestBody Student student,@RequestHeader String token){
        return this.studentwork.updateMe(student,token);
    }
    @GetMapping(path = "/logout")
    public ResponseEntity<?> logout(@RequestHeader String token){
        return this.studentwork.logout(token);
    }
    @PostMapping(path = "/value")
    public ResponseEntity<?> value(@RequestHeader String token,@RequestBody MiniStudent miniStudent){
        if (miniStudent.getProgress()!=null)
            return this.studentwork.updateStudentValue(token,miniStudent);
        else
            return ResponseEntity.badRequest().build();
    }
    @GetMapping(path = "/all")
    public ResponseEntity<?> all(@RequestHeader String token){
        if (token!=null)
            return this.studentwork.topStudent();
        else return ResponseEntity.notFound().build();
    }
    @GetMapping(path = "/my")
    public ResponseEntity<?> my(@RequestHeader String token) {
        if (token!=null)
            return this.studentwork.getminime(token);
        else
            return ResponseEntity.badRequest().build();
    }

}
