package com.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopMongo.domain.Post;
import com.workshopMongo.domain.User;
import com.workshopMongo.repositories.PostRepository;
import com.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	PostRepository postRepository;

	/*
	 * Retorna todos os posts
	 */
	public List<Post> findAll() {

		return postRepository.findAll();
	}

	/*
	 * Procura posts através do ID
	 */
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
