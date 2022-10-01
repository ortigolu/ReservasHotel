package Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Habitacion;
import repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicio {
	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	
	public Habitacion guardarOactualizarHabitacion(Habitacion habitacion) {
		
		//logica
		return habitacionRepositorio.save(habitacion);
		
	}
}
