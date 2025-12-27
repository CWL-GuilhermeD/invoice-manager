package br.com.gdev.invoicemanager.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = StrongPasswordValidation.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

	String message() default "A Senha deve conter no mínimo 8 caracteres, uma letra minúscula, uma letra maiúscula, um numero e um caractere especial.";

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
