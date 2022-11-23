package io.Sheraton.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExcepcionesPersonalizadas extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public final ResponseEntity<Object> handleHabitacionIdExcepcion(HabitacionExcepcionId ex, WebRequest request) {
		HabitacionExcepcionRespuesta respuestaExcepcion = new HabitacionExcepcionRespuesta(ex.getMessage());
		return new ResponseEntity(respuestaExcepcion, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleHabitacionNotFoundException(HabitacionNotFoundExcepcion ex,
			WebRequest request) {
		HabitacionNotFoundExceptionResponse exceptionResponse = new HabitacionNotFoundExceptionResponse(
				ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleUsernameAlreadyExists(UsernameAlreadyExistException ex,
			WebRequest request) {
		UsernameAlreadyExistResponse exceptionResponse = new UsernameAlreadyExistResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
