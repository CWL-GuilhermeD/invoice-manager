package br.com.gdev.invoicemanager.passwordtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import br.com.gdev.invoicemanager.validation.StrongPasswordValidation;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordTest {
	
	private StrongPasswordValidation validator;
	private ConstraintValidatorContext context;
	
	
	@BeforeEach
	void setup() {
		validator = new StrongPasswordValidation();
		
		context = Mockito.mock(ConstraintValidatorContext.class);
		
		ConstraintValidatorContext.ConstraintViolationBuilder builder = Mockito.mock(ConstraintValidatorContext.ConstraintViolationBuilder.class);

		Mockito.when(context.buildConstraintViolationWithTemplate(Mockito.anyString())).thenReturn(builder);
		
		
	}
	
	@Test
	void shouldRejectPasswordNull() {
		boolean result = validator.isValid(null, context);
		assertFalse(result);
	}
	
	@Test void shouldRejectBlankPassword() {
		boolean result = validator.isValid("", context);
		assertFalse(result);
	}
	
	@ParameterizedTest
	@CsvSource({
		"Abc12345!, false",
        "abc12345!, false",
        "ABC12345!, false",
        "Abcdefgh!, false",
        "Abc12345, false",
        "12345678, false",
        "abcde123!, false",
        "qwer1234!, false",
        "Abc12345!@#, false",
        "Gu1lherme@, true",
        "Ab1!Xy2@, true"
	})
	void testPasswords(String password, boolean expected) {
		boolean result = validator.isValid(password, context);
		assertEquals(expected, result);
		
		
	}
}
