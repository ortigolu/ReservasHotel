package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Servicios.HabitacionServicio;
import domain.Habitacion;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionControles {

	@Autowired
	private HabitacionServicio habitacionServicio;
	
	@PostMapping
	public ResponseEntity<Habitacion> crearNuevaHabitacion(@RequestBody Habitacion habitacion){
		Habitacion habitacion1 = habitacionServicio.guardarOactualizarHabitacion(habitacion);
		
		return new ResponseEntity<Habitacion>(habitacion, HttpStatus.CREATED);
		
	}
	
}
