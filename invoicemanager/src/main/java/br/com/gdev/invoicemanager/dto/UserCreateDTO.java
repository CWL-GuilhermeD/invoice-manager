package br.com.gdev.invoicemanager.dto;

import org.hibernate.validator.constraints.Length;

import br.com.gdev.invoicemanager.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
		@NotBlank(message = "O campo login não pode ser vazio.")
		@Length(min = 3, max = 120, message = "O login deve ter entre 3 e 120 caracteres.")
		String login,
		@StrongPassword
		String password) {

}
