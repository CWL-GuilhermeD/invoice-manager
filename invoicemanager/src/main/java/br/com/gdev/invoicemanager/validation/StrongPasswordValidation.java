package br.com.gdev.invoicemanager.validation;

import java.util.Arrays;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.EnglishSequenceData;
import org.passay.IllegalSequenceRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPasswordValidation implements ConstraintValidator<StrongPassword, String>{

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (password == null || password.isBlank()) {
			return false;			
		}
		
		PasswordValidator validator = passwordRules();
		
		RuleResult result = validator.validate(new PasswordData(password));
		
		if (result.isValid()) {
			return true;
		}
		
		context.disableDefaultConstraintViolation();
		
		String messages = String.join(", ", validator.getMessages(result));
		
		context.buildConstraintViolationWithTemplate(messages).addConstraintViolation();
		
		return false;
	}
	
	private static PasswordValidator passwordRules() {
		PasswordValidator validation = new PasswordValidator(Arrays.asList(
				new LengthRule(8,  128),
				new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1),
				new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1),
				new WhitespaceRule(),
				new IllegalSequenceRule(EnglishSequenceData.Numerical, 3, false),
				new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 3, false),
				new IllegalSequenceRule(EnglishSequenceData.USQwerty, 4, false)
				));
		
		return validation;
	}

}
