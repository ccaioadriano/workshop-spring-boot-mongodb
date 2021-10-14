package com.workshopMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopMongo.domain.Post;
import com.workshopMongo.domain.User;
import com.workshopMongo.dto.AuthorDTO;
import com.workshopMongo.dto.CommentDTO;
import com.workshopMongo.repositories.PostRepository;
import com.workshopMongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!!", new AuthorDTO(bob));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!!", new AuthorDTO(alex));
		
		CommentDTO c1 = new CommentDTO(sdf.parse("13/10/2021"), new AuthorDTO(bob), "Boa Viagem!!");
		CommentDTO c2 = new CommentDTO(sdf.parse("7/9/2021"), new AuthorDTO(alex), "São Paulo é muito bom!!");
		CommentDTO c3 = new CommentDTO(sdf.parse("7/10/2021"), new AuthorDTO(maria), "Bom Dia Alex!!");
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		bob.getPosts().addAll(Arrays.asList(post1));
		alex.getPosts().addAll(Arrays.asList(post2));
		
		userRepository.saveAll(Arrays.asList(bob, alex));

	}

}
