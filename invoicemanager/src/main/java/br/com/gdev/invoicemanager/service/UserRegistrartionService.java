package br.com.gdev.invoicemanager.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gdev.invoicemanager.dto.UserCreateDTO;
import br.com.gdev.invoicemanager.dto.UserResponseDTO;
import br.com.gdev.invoicemanager.mapper.UserMapper;
import br.com.gdev.invoicemanager.model.UserModel;
import br.com.gdev.invoicemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrartionService {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	
	public UserResponseDTO registerUser(UserCreateDTO dto) {
		
		UserModel entity = UserMapper.convertCreateDTOToEntity(dto);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));	
		UserModel saveEntity = repository.save(entity);	
		return UserMapper.convertEntityToResponseDTO(saveEntity);				
	}
}
