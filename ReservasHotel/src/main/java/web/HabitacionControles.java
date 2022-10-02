package web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Servicios.HabitacionServicio;
import Servicios.MapValidacionErrorServicio;
import domain.Habitacion;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionControles {

	@Autowired
	private HabitacionServicio habitacionServicio;

	@Autowired
	private MapValidacionErrorServicio mapValidacionErrorServicio;

	@PostMapping
	public ResponseEntity<?> crearNuevaHabitacion(@Valid @RequestBody Habitacion habitacion, BindingResult result) {

		ResponseEntity<?> errorMap = mapValidacionErrorServicio.MapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Habitacion habitacion1 = habitacionServicio.guardarOactualizarHabitacion(habitacion);
		return new ResponseEntity<Habitacion>(habitacion, HttpStatus.CREATED);

	}

}
