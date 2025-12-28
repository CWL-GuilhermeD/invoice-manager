package br.com.gdev.invoicemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gdev.invoicemanager.dto.UserCreateDTO;
import br.com.gdev.invoicemanager.dto.UserResponseDTO;
import br.com.gdev.invoicemanager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody @Valid UserCreateDTO dto){		
		UserResponseDTO response = service.registerUser(dto);		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
}
