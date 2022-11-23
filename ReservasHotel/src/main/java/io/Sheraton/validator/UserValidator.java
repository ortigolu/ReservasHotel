package io.Sheraton.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.Sheraton.domain.Users;

@Component
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		Users users = (Users) object;

		if (users.getPassword().length() < 6) {
			errors.rejectValue("password", "Length", "La contraseña debe tener 6 caracteres minimo");
		}

		if (!users.getPassword().equals(users.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Match", "Las contraseñas deben coincidir");

		}

	}

}
