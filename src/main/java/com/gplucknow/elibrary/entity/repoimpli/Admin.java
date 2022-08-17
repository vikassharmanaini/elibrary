package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "admin")
public class Admin {
    @Id
    private Integer id;
    @Field(name="name")
    private String name;
    @Field(name="email")
    private String email;
    @Field(name = "enroll")
    private String enroll;
    @Field(name = "branch")
    private String branch;
    @Field(name="password")
    private String password;
    @Field(name = "token")
    private String token;
}
