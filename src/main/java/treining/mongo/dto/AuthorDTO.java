package treining.mongo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import treining.mongo.domain.User;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }
}
