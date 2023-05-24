package treining.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;


}
