package net.engineeringdigest.journalApp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface userRepository extends MongoRepository<user,ObjectId >{

}
