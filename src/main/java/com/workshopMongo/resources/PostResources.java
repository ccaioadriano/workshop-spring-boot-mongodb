package com.workshopMongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshopMongo.domain.Post;
import com.workshopMongo.resources.util.URL;
import com.workshopMongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

	@Autowired
	private PostService servicePost;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findbyId(@PathVariable String id) {

		Post post = servicePost.findById(id);

		return ResponseEntity.ok().body(post);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value="title", defaultValue = "") String text) {

		text = URL.decodeParam(text);
		List<Post> listPost = servicePost.findByTitle(text);

		return ResponseEntity.ok().body(listPost);
	}

}
