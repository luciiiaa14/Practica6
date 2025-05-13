package es.unican.ss.Practica6.DTO;

import java.time.LocalDate;

import es.unican.ss.Practica6.domain.Seguro;

public class NuevoParteDTO {
	String dni;
	Seguro seguro;
	double importe;
	LocalDate fecha;
	public NuevoParteDTO(String dni, Seguro seguro, double importe, LocalDate fecha) {
		super();
		this.dni = dni;
		this.seguro = seguro;
		this.importe = importe;
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	

}
