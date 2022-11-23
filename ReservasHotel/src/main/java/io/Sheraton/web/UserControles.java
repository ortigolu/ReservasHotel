package io.Sheraton.web;

import static io.Sheraton.security.SecurityConstants.TOKEN_PREFIX;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.Sheraton.Servicios.MapValidationErrorService;
import io.Sheraton.Servicios.UsersService;
import io.Sheraton.domain.Users;
import io.Sheraton.payload.JWTLoginSucessReponse;
import io.Sheraton.payload.LoginRequest;
import io.Sheraton.security.JwtTokenProvider;
import io.Sheraton.validator.UserValidator;

@RestController
@RequestMapping("/api/users")
public class UserControles {
	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	private UsersService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JWTLoginSucessReponse(true, jwt));
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody Users users, BindingResult result) {
		// Validar contraseñas
		userValidator.validate(users, result);

		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Users newUser = userService.saveUser(users);

		return new ResponseEntity<Users>(newUser, HttpStatus.CREATED);
	}

}
