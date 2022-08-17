package com.gplucknow.elibrary.entity.repoimpli;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "miniStudent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MiniStudent {
    @Id
    private Integer id;
    @Field(name = "studentName")
    private String name;
    @Field(name = "profiling")
    private String pflimg;
    @Field(name="enroll")
    private String enroll;
    @Field(name="overall")
    private Integer averageProgress;
    @Field(name = "progress")
    private String progress;
}
