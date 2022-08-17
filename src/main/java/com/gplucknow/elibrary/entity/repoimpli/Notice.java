package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "notice")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @Id
    private Integer id;
    @Field(name = "noticedate")
    private String date;
    @Field(name = "noticetitle")
    private String title;
    @Field(name = "noticedes")
    private String description;
}
