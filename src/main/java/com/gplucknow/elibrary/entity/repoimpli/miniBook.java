package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "minibook")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class miniBook {
    @Id
    private Integer id;
    @Field(name = "bookname")
    private String name;
    @Field(name = "imagesrc")
    private String imgsrc;
    @Field(name ="tags")
    private String tags;
    @Field(name = "value")
    private Integer value;
}
