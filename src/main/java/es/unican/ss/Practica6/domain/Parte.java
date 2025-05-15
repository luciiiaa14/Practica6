package es.unican.ss.Practica6.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.unican.ss.Practica6.seralizacion.CustomLocalDateDeserializer;
import es.unican.ss.Practica6.seralizacion.CustomLocalDateSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@SuppressWarnings({ "serial" })
public class Parte implements Serializable {
	@Id
	@JsonProperty("id")
	@GeneratedValue
	private Integer idParte;
	@ManyToOne
	@JoinColumn(name = "seguro_id")
	@JsonProperty("seguro")
	private Seguro seguro;
	@JsonProperty("importe")
	private double importe;
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	@JsonDeserialize(using=CustomLocalDateDeserializer.class)
	@JsonProperty("fecha")
	private LocalDate fecha;
	
	public Parte () {
	}

	public Parte(Seguro seguro, double importe, LocalDate fecha, Integer idParte) {
		super();
		this.seguro = seguro;
		this.importe = importe;
		this.fecha = fecha;
		this.idParte = idParte;
	}

	public double getImporte() {
		return importe;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public Integer getIdParte() {
		return idParte;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setIdParte(Integer idParte) {
		this.idParte = idParte;
	}

}
