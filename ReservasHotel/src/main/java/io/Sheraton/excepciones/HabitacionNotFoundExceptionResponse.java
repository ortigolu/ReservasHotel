package io.Sheraton.excepciones;

public class HabitacionNotFoundExceptionResponse {
	private String HabitacionNotFound;

	public HabitacionNotFoundExceptionResponse(String habitacionNotFound) {

		HabitacionNotFound = habitacionNotFound;
	}

	public String getHabitacionNotFound() {
		return HabitacionNotFound;
	}

	public void setHabitacionNotFound(String habitacionNotFound) {
		HabitacionNotFound = habitacionNotFound;
	}

}
