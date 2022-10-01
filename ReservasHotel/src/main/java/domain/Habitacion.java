package domain;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreHabitacion;
	private String identificadorHabitacion;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;

	private Date creado;
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
