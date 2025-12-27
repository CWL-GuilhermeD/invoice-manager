package br.com.gdev.invoicemanager.dto;

import org.hibernate.validator.constraints.Length;

import br.com.gdev.invoicemanager.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
		@NotBlank
		@Length
		String login,
		@StrongPassword
		String password) {

}
