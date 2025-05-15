package es.unican.ss.Practica6.domain;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;



@Entity
@SuppressWarnings({ "serial" })
public class TRFranquicia extends Seguro implements Serializable {
	
	private static final int PRECIO_BASE_TR_FRANQUICIA = 400;
	private double franquicia;
	
	public TRFranquicia() {
		super(PRECIO_BASE_TR_FRANQUICIA);
	}
	
	public TRFranquicia(Long id, LocalDate fechaInicio, Vehiculo vehiculo, double franquicia) {
		super(id, fechaInicio, vehiculo, PRECIO_BASE_TR_FRANQUICIA);
		this.franquicia= franquicia;
	}
	
	
	public double getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(double franquicia) {
		this.franquicia = franquicia;
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
