package com.gplucknow.elibrary.Service.serviceimpli;

import com.gplucknow.elibrary.Service.Studentwork;
import com.gplucknow.elibrary.entity.StudentRepo;
import com.gplucknow.elibrary.entity.miniStudentRepo;
import com.gplucknow.elibrary.entity.repoimpli.MiniStudent;
import com.gplucknow.elibrary.entity.repoimpli.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class Studentimpli implements Studentwork {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    miniStudentRepo miniStudentRepo;
    @Override
    public ResponseEntity<?> createStudent(Student student) {
        student.setId(student.getEnroll().hashCode());
        Supplier<String> tokenSupplier =()->{
            StringBuilder token=new StringBuilder();
            long current= Instant.now().toEpochMilli();
            return token.append(current).append("-").append(UUID.randomUUID().toString()).toString();
        };
        student.setToken(tokenSupplier.get());
        if (studentRepo.insert(student).equals(student)){
            miniStudentRepo.insert(new MiniStudent(student.getId(), student.getName(), student.getProfileimg(),student.getEnroll(),0,""));
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<?> loginStudent(String email,String password) {
        try{
            Supplier<String> tokenSupplier =()->{
                StringBuilder token=new StringBuilder();
                long current= Instant.now().toEpochMilli();
                return token.append(current).append("-").append(UUID.randomUUID().toString()).toString();
            };
            Student s= studentRepo.findByEmail(email);
            if (s.getPassword().equals(password)){
                s.setToken(tokenSupplier.get());
                return ResponseEntity.ok(studentRepo.save(s));
            }
            return ResponseEntity.notFound().build();
        }catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<?> loginStudentEN(String enroll, String password) {
        try{
            Supplier<String> tokenSupplier =()->{
                StringBuilder token=new StringBuilder();
                long current= Instant.now().toEpochMilli();
                return token.append(current).append("-").append(UUID.randomUUID().toString()).toString();
            };
            Student s= studentRepo.findByEnroll(enroll);
            if (s.getPassword().equals(password)){
                s.setToken(tokenSupplier.get());
                return ResponseEntity.ok(studentRepo.save(s));
            }
            return ResponseEntity.notFound().build();
        }catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<?> logout(String token) {
        try{
         Student s = studentRepo.findByToken(token);
         s.setToken(null);
         studentRepo.save(s);
         return ResponseEntity.ok("logout");
        }catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public boolean isLoggedIn(String token) {
        try{
             Student s = studentRepo.findByToken(token);
             if (s.getToken().equals(token))
                return true;
             return false;
        }catch(Exception e) {
            return false;
        }
    }

    @Override
    public ResponseEntity<?> updateMe(Student student,String token) {
        try {
            Student student1 = studentRepo.findByToken(token);
            student.setId(student1.getId());
            student.setEnroll(student1.getEnroll());
            student.setBranch(student1.getBranch());
            student.setToken(token);
            Optional<MiniStudent> miniStudent=miniStudentRepo.findById(student.getId());
            miniStudent.ifPresent(value -> {
                value.setPflimg(student.getProfileimg());
                miniStudentRepo.save(value);
            });
            return ResponseEntity.ok(studentRepo.save(student));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }


    @Override
    public ResponseEntity<?> updateStudentValue(String token ,MiniStudent miniStudent) {
        Optional<MiniStudent> optionalMiniStudent= miniStudentRepo.findById(studentid(token));
        optionalMiniStudent.ifPresent(value->{
            miniStudent.setId(value.getId());
            miniStudent.setPflimg(value.getPflimg());
            miniStudent.setEnroll(value.getEnroll());
            miniStudent.setName(value.getEnroll());
            miniStudent.setAverageProgress(value.getAverageProgress()+1);
        });
        return ResponseEntity.ok(miniStudentRepo.save(miniStudent));
    }

    @Override
    public ResponseEntity<?> topStudent() {
        return ResponseEntity.ok(miniStudentRepo.findAll());
    }

    @Override
    public ResponseEntity<?> getminime(String token) {
        return ResponseEntity.ok(miniStudentRepo.findById(studentid(token)));
    }


    protected Integer studentid(String token) {
        try {
            Student s = studentRepo.findByToken(token);
            return s.getId();
        } catch (Exception e) {
            return 0;
        }
    }
}
