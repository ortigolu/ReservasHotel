package io.Sheraton.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HabitacionNotFoundExcepcion extends RuntimeException {
	public HabitacionNotFoundExcepcion(String message) {
		super(message);
	}
}
