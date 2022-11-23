package excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HabitacionExcepcionId extends RuntimeException {

	public HabitacionExcepcionId(String message) {
		super(message);
	}

}
