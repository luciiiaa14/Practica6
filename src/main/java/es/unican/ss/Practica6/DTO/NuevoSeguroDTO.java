package es.unican.ss.Practica6.DTO;

import java.time.LocalDate;

import es.unican.ss.Practica6.domain.Vehiculo;

public class NuevoSeguroDTO {
	
	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private String tipoSeguro;
	private LocalDate fechaInicio;
	private Vehiculo vehiculo;
	private double precio;
	private String dni;
	
	public NuevoSeguroDTO(String dni, String tipoSeguro, LocalDate fechaInicio, Vehiculo vehiculo, double precio) {
		super();
		this.setDni(dni);
		this.tipoSeguro = tipoSeguro;
		this.fechaInicio = fechaInicio;
		this.vehiculo = vehiculo;
		this.precio = precio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
