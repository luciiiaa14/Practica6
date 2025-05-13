package es.unican.ss.Practica6.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;




@SuppressWarnings({ "serial" })
public class Aseguradora implements Serializable{

	@JsonProperty("clientes")
	private List<Cliente> clientes=new LinkedList<Cliente>();
	
	public Aseguradora(){}
	
	public List<Cliente> getClientes(){
		return clientes;
	}


}