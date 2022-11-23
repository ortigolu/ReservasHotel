package Servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import domain.Users;
import repositorios.UsersRepositorio;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepositorio userRepositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepositorio.findByUsername(username);
		if (users == null)
			new UsernameNotFoundException("Usuario no encontrado");
		return users;
	}

	@Transactional
	public Users loadUserById(Long id) {
		Users users = userRepositorio.getById(id);
		if (users == null)
			new UsernameNotFoundException("Usuario no encontrado");
		return users;

	}

}
