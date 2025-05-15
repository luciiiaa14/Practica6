package es.unican.ss.Practica6.DTO;

import java.time.LocalDate;


public class NuevoParteDTO {
	String dni;
	Long  idSeguro;
	double importe;
	LocalDate fecha;
	public NuevoParteDTO(String dni, Long seguro, double importe, LocalDate fecha) {
		super();
		this.dni = dni;
		this.idSeguro = seguro;
		this.importe = importe;
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Long getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(Long seguro) {
		this.idSeguro = seguro;
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
