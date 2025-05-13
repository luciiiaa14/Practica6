package es.unican.ss.Practica6.domain;

import java.io.Serializable;
import java.time.LocalDate;



@SuppressWarnings({ "serial" })
public class TodoRiesgo extends Seguro implements Serializable{
	
	private static final int PRECIO_BASE_TODO_RIESGO = 600;
	
	
	public TodoRiesgo() {
		super(PRECIO_BASE_TODO_RIESGO);
	}
	
	public TodoRiesgo(String id, LocalDate fechaInicio, Vehiculo vehiculo) {
		super(id, fechaInicio, vehiculo, PRECIO_BASE_TODO_RIESGO);
	}
	
	@Override
	public double calculaPrecio() {
		double precio= getPrecioBase()+getVehiculo().getCv()*Seguro.MULTIPLICADOR_POTENCIA;
		if(getVehiculo().esProfesional()){
			precio+=Seguro.AUMENTO_PROFESIONAL;
		}
		return precio;
	}
}
