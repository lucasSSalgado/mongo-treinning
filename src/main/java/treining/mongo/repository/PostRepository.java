package treining.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import treining.mongo.domain.Post;
import treining.mongo.domain.User;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ body: { $regex: ?0, $options: 'i' } }")
    List<Post> searchInBody(String text);


    @Query("{ $and: [ { date: { $gte: ?0 } }, { date: { $lte: ?1 } }, { $or: [ { body: { $regex: ?2, $options: 'i' } }, { title: { $regex: ?2, $options: 'i' } }, { 'commentDTOList.text': { $regex: ?2, $options: 'i' } } ] } ] }")
    List<Post> searchByTextAndData(Date minDate, Date maxDate, String text);

}
