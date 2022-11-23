package io.Sheraton.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.Sheraton.Servicios.HabitacionServicio;
import io.Sheraton.Servicios.MapValidacionErrorServicio;
import io.Sheraton.domain.Habitacion;

@RestController
@RequestMapping("/api/habitacion")
@CrossOrigin
public class HabitacionControles {

	@Autowired
	private HabitacionServicio habitacionServicio;

	@Autowired
	private MapValidacionErrorServicio mapValidacionErrorServicio;

	@PostMapping("")
	public ResponseEntity<?> crearNuevaHabitacion(@Valid @RequestBody Habitacion habitacion, BindingResult result,
			Principal principal) {

		ResponseEntity<?> errorMap = mapValidacionErrorServicio.MapValidationService(result);
		if (errorMap != null)
			return errorMap;

		Habitacion habitacion1 = habitacionServicio.guardarOactualizarHabitacion(habitacion, principal.getName());
		return new ResponseEntity<Habitacion>(habitacion, HttpStatus.CREATED);

	}

	@GetMapping("/{habitacionId}")
	public ResponseEntity<?> getHabitacionId(@PathVariable String habitacionId, Principal principal) {
		Habitacion habitacion = habitacionServicio.encontrarHabitacionPorIdentificador(habitacionId,
				principal.getName());
		return new ResponseEntity<Habitacion>(habitacion, HttpStatus.OK);

	}

	@GetMapping("/all")
	public Iterable<Habitacion> getAllHabitaciones(Principal principal) {
		return habitacionServicio.findAllHabitacion(principal.getName());
	}

	@DeleteMapping("/{habitacionId}")
	public ResponseEntity<?> eliminarHabitacion(@PathVariable String habitacionId, Principal principal) {
		habitacionServicio.deleteHabitacionByIdentifier(habitacionId, principal.getName());
		return new ResponseEntity<String>("Habitacion con ID: " + habitacionId + "ha sido eliminado", HttpStatus.OK);

	}

}
