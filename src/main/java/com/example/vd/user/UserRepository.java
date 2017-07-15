package com.example.vd.user;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by leandropozer on 20/06/17.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByName(String name);
    public User findByUserName(String userName);
}
