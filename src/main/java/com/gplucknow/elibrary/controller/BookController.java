package com.gplucknow.elibrary.controller;

import com.gplucknow.elibrary.Service.Bookwork;
import com.gplucknow.elibrary.helper.bookmarkHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/book")
public class BookController {
    @Autowired
    Bookwork bookwork;
    @GetMapping(path = "/add")
    public ResponseEntity addbook(@RequestBody Integer bookId,@RequestHeader String token){
        if (bookId!=null && token !=null)
            return bookwork.addInCurrentBook(bookId,token);
        else return ResponseEntity.badRequest().body("Null cannot be accepted");
    }
    @GetMapping(path = "/delete")
    public boolean deletebook(@RequestHeader String token,@RequestBody Integer mybookid ){
        return this.bookwork.deleteFromCurrentBook(token,mybookid);
    }
    @GetMapping(path = "/")
    public ResponseEntity<?> getmybooks(@RequestHeader String token){
        return this.bookwork.getmybook(token);
    }
    @PostMapping(path = "/")
    public ResponseEntity<?> getallminibook(@RequestBody List<Integer> bookIds){
        return this.bookwork.getListOfMiniBook(bookIds);
    }
    @PostMapping(path = "/bookmarks")
    public ResponseEntity<?> addbookmarks(@RequestHeader String token ,@RequestBody bookmarkHelper bookmarkHelper){
        return this.bookwork.addBookmark(token,bookmarkHelper.getBookId(),bookmarkHelper.getPage());
    }
    @DeleteMapping(path ="/bookmarks")
    public ResponseEntity<?> deletebookmark(@RequestHeader String token,@RequestBody bookmarkHelper bookmarkHelper){
        return this.bookwork.deleteBookmark(token,bookmarkHelper.getBookId());
    }
    @GetMapping(path = "/bookmarks")
    public ResponseEntity<?> getbookmark(@RequestHeader String token){
        return this.bookwork.getmybookmark(token);
    }
    @GetMapping(path = "/full")
    public ResponseEntity<?> getcompletebook(@RequestHeader String token,@RequestBody bookmarkHelper bookmarkHelper){
        return this.bookwork.getCompletebook(bookmarkHelper.getBookId());
    }
    @GetMapping(path = "/top")
    public ResponseEntity<?> gettopbooks(@RequestHeader String token){
        return this.bookwork.topBooks();
    }
}

