package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private  Integer id;
    @Field(name = "name")
    private String name;
    @Field(name = "enroll")
    private String enroll;
    @Field(name="profileimg")
    private String profileimg;
    @Field(name="branch")
    private String branch;
    @Field(name = "email")
    private String email;
    @Field(name = "password")
    private String password;
    @Field(name="token")
    private String token;
}
