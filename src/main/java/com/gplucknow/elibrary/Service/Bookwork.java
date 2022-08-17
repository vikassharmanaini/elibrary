package com.gplucknow.elibrary.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Bookwork {
    public ResponseEntity<?> addInCurrentBook(Integer bookId,String studentToken);
    public boolean deleteFromCurrentBook(String token,Integer Mybookid);
    public ResponseEntity<?> getmybook(String token);
    public ResponseEntity<?> addBookmark(String token,Integer bookId,Integer bookPage);
    public ResponseEntity<?> getmybookmark(String token);
    public ResponseEntity<?> deleteBookmark(String token,Integer bookmarkId);
    public ResponseEntity<?> topBooks();
    public ResponseEntity<?> getCompletebook(Integer bookId);
    public ResponseEntity<?> getListOfMiniBook(List<Integer> bookidlist);

}
