package Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicio {
	@Autowired
	private HabitacionRepositorio habitacionRepositorio;

}
