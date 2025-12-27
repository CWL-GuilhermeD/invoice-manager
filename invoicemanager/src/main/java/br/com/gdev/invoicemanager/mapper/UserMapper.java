package br.com.gdev.invoicemanager.mapper;

import org.mapstruct.Mapper;

import br.com.gdev.invoicemanager.dto.UserCreateDTO;
import br.com.gdev.invoicemanager.dto.UserResponseDTO;
import br.com.gdev.invoicemanager.dto.UserUpdateDTO;
import br.com.gdev.invoicemanager.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserModel convertCreateDTOToEntity(UserCreateDTO dto);
	
	UserModel convertUpdateDTOToEntity(UserUpdateDTO dto);
	
	UserCreateDTO convertEntityToCreateDTO(UserModel entity);
	
	UserUpdateDTO convertEntityToUpdateDTO(UserModel entity);
	
	UserResponseDTO convertEntityToResponseDTO(UserModel entity);
	
}
