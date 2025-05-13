package es.unican.ss.Practica6.service;

import java.time.LocalDate;
import java.util.List;

import es.unican.ss.Practica6.domain.Cliente;
import es.unican.ss.Practica6.domain.Parte;
import es.unican.ss.Practica6.domain.Seguro;
import es.unican.ss.Practica6.domain.Vehiculo;

public interface IAseguradoraService {
	
	public List<Cliente> clientes();
	
	public Cliente clientePorDNI (String dni);
	
	public  Cliente creaCliente(Cliente c);
	
	public Double obtenerImporteCliente(String dni);
	
	public Seguro crearSeguroCliente (String dni, String tipoSeguro, LocalDate fechaInicio, Vehiculo vehiculo, double precio);
	
	public Parte crearParteCliente (String dni, Seguro seguro, double importe, LocalDate fecha);
	

}
