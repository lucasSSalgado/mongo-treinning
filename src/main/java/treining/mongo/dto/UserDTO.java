package treining.mongo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import treining.mongo.domain.User;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
