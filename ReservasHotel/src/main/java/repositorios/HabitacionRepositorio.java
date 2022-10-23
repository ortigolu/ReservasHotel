package repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Habitacion;

@Repository
public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> {

	Habitacion findByIdentificadorHabitacion(String habitacionId);

	@Override
	Iterable<Habitacion> findAll();

}
