package domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "El nombre es requisito")
	private String nombreHabitacion;
	@NotNull(message = "El identificador de la habitacion es requerido")
	@Size(min = 4, max = 5, message = "Porfavor use de 4 a 5 caracteres")
	@Column(updatable = false, unique = true)
	private String identificadorHabitacion;
	@NotNull(message = "La descripcion de la habitacion es requerido")
	private String descripcion;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date fechaInicio;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date fechaFin;

	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(updatable = false)
	private Date creado;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date actualizado;

	public Habitacion() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreHabitacion() {
		return nombreHabitacion;
	}

	public void setNombreHabitacion(String nombreHabitacion) {
		this.nombreHabitacion = nombreHabitacion;
	}

	public String getIdentificadorHabitacion() {
		return identificadorHabitacion;
	}

	public void setIdentificadorHabitacion(String identificadorHabitacion) {
		this.identificadorHabitacion = identificadorHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getCreado() {
		return creado;
	}

	public void setCreado(Date creado) {
		this.creado = creado;
	}

	public Date getActualizado() {
		return actualizado;
	}

	public void setActualizado(Date actualizado) {
		this.actualizado = actualizado;
	}

	@PrePersist
	protected void enCreacion() {
		this.creado = new Date();
	}

	@PreUpdate
	protected void en_Actualizacion() {
		this.actualizado = new Date();
	}

}
