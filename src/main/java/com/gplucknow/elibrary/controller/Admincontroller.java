package com.gplucknow.elibrary.controller;

import com.gplucknow.elibrary.Service.AdminService;
import com.gplucknow.elibrary.Service.noticeService;
import com.gplucknow.elibrary.entity.repoimpli.Admin;
import com.gplucknow.elibrary.entity.repoimpli.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/admin")
public class Admincontroller {
    @Autowired
    private Admin admin;
    @Autowired
    private AdminService service;
    @Autowired
    private noticeService noticeService;
    @PostMapping(path = "/signup")
    public ResponseEntity<?> signup(@RequestBody Admin admin){
        return service.signUp(admin);
    }
    @GetMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody Admin admin){
        return service.logIn(admin.getEmail(), admin.getPassword());
    }
    @GetMapping(path = "/auth")
    public ResponseEntity<?> auth(@RequestHeader String token){
        return service.auth(token);
    }

    @PostMapping(path = "/notice")
    public ResponseEntity<?> addnotice(@RequestHeader String token,@RequestBody Notice notice){
     return noticeService.addnotice(token,notice);
    }

    @GetMapping(path = "/notice")
    public ResponseEntity<?> getall(){
        return noticeService.getnotice();
    }
}
