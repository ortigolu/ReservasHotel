package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Backlog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence = 0;
	private String identificadorHabitacion;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "habitacion_id", nullable = false)
	@JsonIgnore

	private Habitacion habitacion;

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Backlog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPTSequence() {
		return PTSequence;
	}

	public void setPTSequence(Integer pTSequence) {
		PTSequence = pTSequence;
	}

	public String getIdentificadorHabitacion() {
		return identificadorHabitacion;
	}

	public void setIdentificadorHabitacion(String identificadorHabitacion) {
		this.identificadorHabitacion = identificadorHabitacion;
	}

	// Uno a uno con habitacion

}
