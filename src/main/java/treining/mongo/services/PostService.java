package treining.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treining.mongo.domain.Post;
import treining.mongo.exceptions.ObjNotFindException;
import treining.mongo.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjNotFindException("Objeto nao encontrato para id: " + id));
    }
}
