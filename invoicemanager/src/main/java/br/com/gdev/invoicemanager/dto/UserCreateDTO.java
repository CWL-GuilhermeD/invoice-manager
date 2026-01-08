package br.com.gdev.invoicemanager.dto;

import br.com.gdev.invoicemanager.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {
	
	@NotBlank(message = "O campo login não pode ser vazio.")
	@Size(min = 3, max = 120, message = "O login deve ter entre 3 e 120 caracteres.")
	private String login;
	@StrongPassword(message = "Senha Fraca de mais.")
	@NotBlank(message = "O campo senha não pode ser vazio.")
	private String password;
}
