package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "mybook")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class mybook {
    @Id
    private Integer id;
    @Field(name = "studentid")
    private Integer studentId;
    @Field(name = "bookid")
    private  Integer bookId;
}
