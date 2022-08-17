package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    private Integer id;
    @Field(name = "name")
    private String name;
    @Field(name="authors")
    private String authors;
    @Field(name = "publication")
    private String publication;
    @Field(name="src")
    private String src;
    @Field(name = "bookimage")
    private String imgsrc;
    @Field(name="booktags")
    private String tags;
}
