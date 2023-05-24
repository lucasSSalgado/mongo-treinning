package treining.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treining.mongo.domain.User;
import treining.mongo.dto.UserDTO;
import treining.mongo.exceptions.ObjNotFindException;
import treining.mongo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjNotFindException("Objeto nao encontrato para id: " + id));
    }

    public User save(User user) {
        User newUser = repository.save(user);
        return newUser;
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

//    public void fromDTO(UserDTO dto) {
//        User user = new User(dto.getId(), dto.getName(), dto.getEmail(), "");
//    }
}
