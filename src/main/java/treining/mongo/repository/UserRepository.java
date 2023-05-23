package treining.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import treining.mongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
