package br.com.gdev.invoicemanager.mapper;

import br.com.gdev.invoicemanager.dto.UserCreateDTO;
import br.com.gdev.invoicemanager.dto.UserResponseDTO;
import br.com.gdev.invoicemanager.dto.UserUpdateDTO;
import br.com.gdev.invoicemanager.model.UserModel;

public class UserMapper {
	
	private UserMapper() {}
	
	public static UserModel convertCreateDTOToEntity(UserCreateDTO dto) {
		UserModel user = new UserModel();
		user.setLogin(dto.login());
		user.setPassword(dto.password());
		return user;
	}
	
	public static UserModel convertUpdateDTOToEntity(UserUpdateDTO dto, UserModel entity) {		
		entity.setLogin(dto.login());
		entity.setPassword(dto.password());
		return entity;
	}
	
	public static UserResponseDTO convertEntityToResponseDTO(UserModel entity) {
		return new UserResponseDTO(entity.getId(), entity.getLogin());
	}	
}
