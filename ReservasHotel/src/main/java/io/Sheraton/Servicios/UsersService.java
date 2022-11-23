package Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import domain.Users;
import excepciones.UsernameAlreadyExistException;
import repositorios.UsersRepositorio;

@Service
public class UsersService {
	@Autowired
	private UsersRepositorio userRepositorio;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Users saveUser(Users newUser) {
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			// Username tiene que ser unico (exception)
			newUser.setUsername(newUser.getUsername());
			// Asegurar que las contraseñas coincidan
			newUser.setConfirmPassword("");
			return userRepositorio.save(newUser);

		} catch (Exception e) {
			throw new UsernameAlreadyExistException("Username '" + newUser.getUsername() + "' already exists");
		}

	}

}
