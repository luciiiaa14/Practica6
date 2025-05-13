package es.unican.ss.Practica6.domain;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;


@SuppressWarnings({ "serial" })
public class Vehiculo implements Serializable{
	@JsonProperty("matricula")
	private String matricula;
	@JsonProperty("cv")
	private int cv;
	@JsonProperty("profesional")
	private boolean esProfesional;
	
	public Vehiculo(String mat, int cv, boolean esPro){
		this.matricula=mat;
		this.cv=cv;
		this.esProfesional=esPro;
	}
	
	public Vehiculo(){	}

	public int getCv() {
		return cv;
	}

	public void setCv(int cv) {
		this.cv = cv;
	}

	public boolean esProfesional() {
		return esProfesional;
	}

	public void setEsProfesional(boolean esProfesional) {
		this.esProfesional = esProfesional;
	}

	public String getMatricula() {
		return matricula;
	}
		
	public boolean isEsProfesional() {
		return esProfesional;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
