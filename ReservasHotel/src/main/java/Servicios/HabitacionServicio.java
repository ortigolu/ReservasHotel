package Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Habitacion;
import excepciones.HabitacionExcepcionId;
import repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicio {
	@Autowired
	private HabitacionRepositorio habitacionRepositorio;

	public Habitacion guardarOactualizarHabitacion(Habitacion habitacion) {

		// logica
		try {
			habitacion.setIdentificadorHabitacion(habitacion.getIdentificadorHabitacion().toUpperCase());
			return habitacionRepositorio.save(habitacion);

		} catch (Exception e) {
			throw new HabitacionExcepcionId(
					"Habitacion Id " + habitacion.getIdentificadorHabitacion().toUpperCase() + " ya existe");
		}

	}

	public Habitacion encontrarHabitacionPorIdentificador(String habitacionId) {
		Habitacion habitacion = habitacionRepositorio.findByIdentificadorHabitacion(habitacionId.toUpperCase());
		if (habitacion == null) {
			throw new HabitacionExcepcionId("Habitacion Id " + habitacionId + " no existe");

		}
		return habitacion;
	}

	public Iterable<Habitacion> findAllHabitacion() {
		return habitacionRepositorio.findAll();
	}

	public void borrarHabitacionPorIdentificador(String habitacionId) {
		Habitacion habitacion = habitacionRepositorio.findByIdentificadorHabitacion(habitacionId.toUpperCase());
		if (habitacion == null) {

			throw new HabitacionExcepcionId(
					"No se puede eliminar la habitacion con el ID " + habitacionId + ". Esta habitacion no existe");

		}
		habitacionRepositorio.delete(habitacion);
	}
}
