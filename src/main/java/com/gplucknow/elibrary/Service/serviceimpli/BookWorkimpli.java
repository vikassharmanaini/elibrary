package com.gplucknow.elibrary.Service.serviceimpli;

import com.gplucknow.elibrary.Service.Bookwork;
import com.gplucknow.elibrary.entity.*;
import com.gplucknow.elibrary.entity.repoimpli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookWorkimpli implements Bookwork {
    @Autowired
    BookmarkRepo bookmarkRepo;
    @Autowired
    bookRepo bookRepo;
    @Autowired
    LearnedBookRepo learnedBookRepo;
    @Autowired
    miniBookRepo miniBookRepo;
    @Autowired
    MyBookRepo myBookRepo;

    /**
     * Validate book id;
     * Get student id
     * Add them
     * Increase value
     * @param bookId
     * book id that we want to add
     * @param studentToken
     * Student login token
     * @return studentbooks as response
     */
    @Override
    public ResponseEntity<?> addInCurrentBook(Integer bookId, String studentToken) {
        Integer id = getid(studentToken);
        if (validatebookid(bookId)){
                miniBook miniBook= miniBookRepo.findById(bookId).get();
                miniBook.setValue(miniBook.getValue()+1);
                miniBookRepo.save(miniBook);
                ResponseEntity.ok(myBookRepo.save(new mybook((id+""+bookId).hashCode(),id, bookId)));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * validate book id
     * validate token
     * delete book
     * @param token
     * Student login token
     * @param Mybookid
     * Current book id
     * @return Response the true if deleted
     */
    @Override
    public boolean deleteFromCurrentBook(String token, Integer Mybookid) {
        Optional<miniBook> miniBook=this.miniBookRepo.findById(Mybookid);
        if (miniBook.isPresent()) {
            Integer id = getid(token);
            learnedBookRepo.save(new Learnedbook((id + "" + Mybookid).hashCode(), id,miniBook.get().getId(),miniBook.get().getName()));
            this.myBookRepo.deleteById(Mybookid);
            return true;
        }
            return false;
    }

    /**
     * this will get all books of user
     * 1-> validate token
     * 2->get book
     * @param token
     * Student login token
     * @return list of my book
     */
    @Override
    public ResponseEntity<?> getmybook(String token) {
        return ResponseEntity.ok(myBookRepo.findByStudentId(getid(token)));
    }

    /**
     * this will add bookmark
     * 1->  get id;
     * 2->  validate bookId
     * 3->  add
     * @param token
     * student token
     * @param bookId
     * book id that we want to add
     * @param bookPage
     * page number that will bookmarked
     * @return bookmark
     */
    @Override
    public ResponseEntity<?> addBookmark(String token, Integer bookId, Integer bookPage) {
        if (validatebookid(bookId)){
            Integer id=getid(token);
            return ResponseEntity.ok(bookmarkRepo.save(new Bookmark((id+""+bookId+""+bookPage).hashCode(),id,bookId,bookPage)));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> getmybookmark(String token) {
        return ResponseEntity.ok(bookmarkRepo.findByStudentId(getid(token)));
    }

    @Override
    public ResponseEntity<?> deleteBookmark(String token, Integer bookmarkId) {
        if(bookmarkRepo.findById(bookmarkId).isPresent()){
            bookmarkRepo.deleteById(bookmarkId);
            return ResponseEntity.ok("Item deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> topBooks() {
        return ResponseEntity.ok(miniBookRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getCompletebook(Integer bookId) {
        return ResponseEntity.ok(bookRepo.findById(bookId));
    }

    @Override
    public ResponseEntity<?> getListOfMiniBook(List<Integer> bookidlist) {
        return ResponseEntity.ok(miniBookRepo.findAllById(bookidlist));
    }

    private Integer getid(String token){
        return new Studentimpli().studentid(token);
    }
    private boolean validatebookid(Integer bookid){
       Optional<miniBook>optionalMiniBook=miniBookRepo.findById(bookid);
        return optionalMiniBook.isPresent();
    }
}
