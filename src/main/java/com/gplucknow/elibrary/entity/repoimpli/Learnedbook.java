package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "learneedbook")
public class Learnedbook {
   private Integer id;
   private Integer Stuedentid;
   private Integer bookid;
   private String bookname;
}
