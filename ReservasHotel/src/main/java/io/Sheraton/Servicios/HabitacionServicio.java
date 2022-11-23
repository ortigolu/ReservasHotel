package Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Backlog;
import domain.Habitacion;
import domain.Users;
import excepciones.HabitacionExcepcionId;
import excepciones.HabitacionNotFoundExcepcion;
import repositorios.BacklogRepositorio;
import repositorios.HabitacionRepositorio;
import repositorios.UsersRepositorio;

@Service
public class HabitacionServicio {
	@Autowired
	private HabitacionRepositorio habitacionRepositorio;

	@Autowired
	private BacklogRepositorio backlogRepositorio;

	@Autowired
	private UsersRepositorio usersRepositorio;

	public Habitacion guardarOactualizarHabitacion(Habitacion habitacion, String username) {

		if (habitacion.getId() != null) {
			Habitacion existingHabitacion = habitacionRepositorio
					.findByIdentificadorHabitacion(habitacion.getIdentificadorHabitacion());
			if (existingHabitacion != null && (!existingHabitacion.getHabitacionLeader().equals(username))) {
				throw new HabitacionNotFoundExcepcion("Habitacion no encontrada en su cuenta");
			} else if (existingHabitacion == null) {
				throw new HabitacionNotFoundExcepcion("Habitacion con ID: '" + habitacion.getIdentificadorHabitacion()
						+ "' no puede ser actualizado porque no existe");
			}
		}
		try {
			Users users = usersRepositorio.findByUsername(username);
			habitacion.setUsers(users);
			habitacion.setHabitacionLeader(users.getUsername());
			habitacion.setIdentificadorHabitacion(habitacion.getIdentificadorHabitacion().toUpperCase());

			if (habitacion.getId() == null) {
				Backlog backlog = new Backlog();
				habitacion.setBacklog(backlog);
				backlog.setHabitacion(habitacion);
				backlog.setIdentificadorHabitacion(habitacion.getIdentificadorHabitacion().toUpperCase());

			}

			if (habitacion.getId() != null) {
				habitacion.setBacklog(backlogRepositorio
						.findbyIdenttificadorHabitacion(habitacion.getIdentificadorHabitacion().toUpperCase()));

			}

			return habitacionRepositorio.save(habitacion);

		} catch (Exception e) {
			throw new HabitacionExcepcionId(
					"Habitacion Id " + habitacion.getIdentificadorHabitacion().toUpperCase() + " ya existe");
		}

	}

	public Habitacion encontrarHabitacionPorIdentificador(String habitacionId, String username) {
		Habitacion habitacion = habitacionRepositorio.findByIdentificadorHabitacion(habitacionId.toUpperCase());
		if (habitacion == null) {
			throw new HabitacionExcepcionId("Habitacion Id " + habitacionId + " no existe");

		}

		if (!habitacion.getHabitacionLeader().equals(username)) {
			throw new HabitacionNotFoundExcepcion("La habitacion no se ha encontrado en su cuenta");
		}

		return habitacion;
	}

	public Iterable<Habitacion> findAllHabitacion(String username) {
		return habitacionRepositorio.findAllByHabitacionLeader(username);
	}

	public void deleteHabitacionByIdentifier(String habitacionid, String username) {

		habitacionRepositorio.delete(encontrarHabitacionPorIdentificador(habitacionid, username));

	}
}
