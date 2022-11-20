package repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Backlog;

@Repository
public interface BacklogRepositorio extends CrudRepository<Backlog, Long> {
	Backlog findbyIdenttificadorHabitacion(String Identirficador);

}
