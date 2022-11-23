package io.Sheraton.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.Sheraton.domain.Habitacion;

@Repository
public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> {

	Habitacion findByIdentificadorHabitacion(String habitacionId);

	@Override
	Iterable<Habitacion> findAll();

	Iterable<Habitacion> findAllByHabitacionLeader(String username);

}
