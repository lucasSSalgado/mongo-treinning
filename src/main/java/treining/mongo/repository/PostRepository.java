package treining.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import treining.mongo.domain.Post;
import treining.mongo.domain.User;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ body: { $regex: ?0 } }")
    List<Post> searchInBody(String text);
}
