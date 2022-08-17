package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "bookmark")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bookmark {
    @Id
    private Integer id;
    @Field(name = "stuid")
    private Integer studentId;
    @Field(name = "bookid")
    private Integer bookid;
    @Field(name="bookpage")
    private Integer bookpage;
}
