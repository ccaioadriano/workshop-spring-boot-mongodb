package com.workshopMongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	/*
	 * Retorna uma consulta pelo titulo do post, recebendo como parametro o titulo a ser buscado
	 * */
	List<Post> findByTitleContainingIgnoreCase (String title);
}
