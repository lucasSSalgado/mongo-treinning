package treining.mongo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import treining.mongo.dto.AuthorDTO;
import treining.mongo.dto.CommentDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO autor;

    private List<CommentDTO> commentDTOList = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDTO autor) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.autor = autor;
    }
}
