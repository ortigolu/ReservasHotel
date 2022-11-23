package io.Sheraton.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.Sheraton.domain.Users;

@Repository
public interface UsersRepositorio extends CrudRepository<Users, Long> {
	Users findByUsername(String username);

	Users getById(Long id);

}
