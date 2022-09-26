package repositorios;
import domain.Habitacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepositorio extends CrudRepository<Habitacion, Long> {

	@Override
	Iterable<Habitacion> findAllById(Iterable<Long> iterable);
	
	

}
