package es.unican.ss.Practica6.domain;

import java.io.Serializable;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.unican.ss.Practica6.seralizacion.CustomLocalDateDeserializer;
import es.unican.ss.Practica6.seralizacion.CustomLocalDateSerializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, 
				include= JsonTypeInfo.As.PROPERTY,
				property = "type")
@JsonSubTypes({
	@Type(value=Terceros.class, name="terceros"),
	@Type(value=TodoRiesgo.class, name="todoRiesgo"),
	@Type(value=TRFranquicia.class, name="franquicia"),

})
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@SuppressWarnings({ "serial" })
public abstract class Seguro implements Serializable {
	
	public static final double AUMENTO_PROFESIONAL = 100.0;
	public static final double MULTIPLICADOR_POTENCIA = 1.5;
	@Id
	@JsonProperty("id")
	@GeneratedValue
	private Long id;
	@JsonProperty("fecha")
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	@JsonDeserialize(using=CustomLocalDateDeserializer.class)
	private LocalDate fechaInicio;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonProperty("vehiculo")
	@JoinColumn(name = "vehiculo_matricula")
	private Vehiculo vehiculo;
	@JsonProperty("precioBase")
	private double precioBase;

	public Seguro(){
	}
	
	public Seguro(Long id, LocalDate fechaInicio, Vehiculo vehiculo, double precioBase) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.vehiculo = vehiculo;
		this.precioBase = precioBase;
	}

	public Seguro (double precioBase) {
		this.precioBase = precioBase;
	}
	
	public Long getId() {
		return id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public double getPrecioBase() {
		return precioBase;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public abstract double calculaPrecio();
	
}
