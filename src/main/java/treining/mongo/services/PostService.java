package treining.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import treining.mongo.domain.Post;
import treining.mongo.exceptions.ObjNotFindException;
import treining.mongo.repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjNotFindException("Objeto nao encontrato para id: " + id));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> searchInBody(String text) {
        return repository.searchInBody(text);
    }

    public List<Post> searchByTextAndData(Date minDate, Date maxDate, String text) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000);
        return repository.searchByTextAndData(minDate, maxDate, text);
    }
}
