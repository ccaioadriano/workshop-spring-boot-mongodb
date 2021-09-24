package com.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopMongo.domain.User;
import com.workshopMongo.dto.UserDTO;
import com.workshopMongo.repositories.UserRepository;
import com.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	/*
	 * Retorna todos os Usuários
	 * */
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	/*
	 * Procura usuários através do ID
	 * */
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	/*
	 * Insere um usuário no banco de dados
	 * */
	public User insert(User obj) {
		return userRepository.insert(obj);
	}
	
	/*
	 * Deleta um usuário no banco de dados
	 * */
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	/*
	 * Atualiza um usuário no banco de dados
	 * */
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return userRepository.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	

	
	
}
