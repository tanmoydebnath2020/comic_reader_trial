package com.bits.comicreader.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bits.comicreader.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	public User findByEmailIdAndPassword(String emailId, String password);
}
