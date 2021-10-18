package com.workshopMongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.workshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	@Query("{'title': {$regex: ?0, '$options':'i'}}")
	List<Post> findByTitle (String title); 
		
	
	
	
	/*
	 * Retorna uma consulta pelo titulo do post, recebendo como parametro o titulo a ser buscado
	 * */
	List<Post> findByTitleContainingIgnoreCase (String title);
}
