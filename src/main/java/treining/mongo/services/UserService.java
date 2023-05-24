package treining.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treining.mongo.domain.User;
import treining.mongo.repository.UserRepository;
import treining.mongo.exceptions.ObjNotFindException;

import java.util.List;
import java.util.Optional;

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
}
