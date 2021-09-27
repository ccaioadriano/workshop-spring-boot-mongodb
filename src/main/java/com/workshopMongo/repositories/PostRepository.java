package com.workshopMongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.workshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
