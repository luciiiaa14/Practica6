package es.unican.ss.Practica6.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
@SuppressWarnings({ "serial" })
public class Terceros extends Seguro implements Serializable{
	
	private static final int PRECIO_BASE_TERCEROS = 200;
	
	public Terceros() {
		super(PRECIO_BASE_TERCEROS);
	}
	
	public Terceros(Long id, LocalDate fechaInicio, Vehiculo vehiculo) {
		super(id, fechaInicio, vehiculo, PRECIO_BASE_TERCEROS);
	}

	@Override
	public double calculaPrecio() {
		return getPrecioBase()+getVehiculo().getCv()*Seguro.MULTIPLICADOR_POTENCIA;
	}
}