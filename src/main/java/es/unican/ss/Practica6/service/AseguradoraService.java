package es.unican.ss.Practica6.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.unican.ss.Practica6.Repositories.ClienteRepository;
import es.unican.ss.Practica6.Repositories.ParteRepository;
import es.unican.ss.Practica6.Repositories.SeguroRepository;
import es.unican.ss.Practica6.domain.Cliente;
import es.unican.ss.Practica6.domain.Parte;
import es.unican.ss.Practica6.domain.Seguro;
import es.unican.ss.Practica6.domain.TRFranquicia;
import es.unican.ss.Practica6.domain.Terceros;
import es.unican.ss.Practica6.domain.TodoRiesgo;
import es.unican.ss.Practica6.domain.Vehiculo;

@Service
public class AseguradoraService implements IAseguradoraService {
	private ClienteRepository clienteRepository;
	private SeguroRepository seguroRepository;
	private ParteRepository parteRepository;
	
	
	public AseguradoraService (ClienteRepository clienteRepository, SeguroRepository seguroRepository,
			ParteRepository parteRepository) {
		this.clienteRepository = clienteRepository;
		this.seguroRepository = seguroRepository;
		this.parteRepository = parteRepository;
	}
	
	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}
	
	public Cliente clientePorDNI (String dni) {
		return clienteRepository.findByDni(dni);
	}
	
	public  Cliente creaCliente(Cliente c) {
		if (clienteRepository.findByDni(c.getDni()) != null) {
			return null;
		}
		return clienteRepository.save(c);
	}
	
	
	public Double obtenerImporteCliente(String dni) {
		Cliente c = clienteRepository.findByDni(dni);
		if (c == null) {
			return null;
		}
		
		return c.totalSeguros();
		
	}

	
	public Seguro crearSeguroCliente (String dni, String tipoSeguro, LocalDate fechaInicio, Vehiculo vehiculo, double precio) {
		Cliente c = clienteRepository.findByDni(dni);
		if (c == null) {
			return null;
		}
		Seguro seguroCliente;
		switch (tipoSeguro.toUpperCase()) {
			case "TERCEROS":
				seguroCliente = new Terceros(null, fechaInicio, vehiculo);
				break;
			case "TODORIESGO":
				seguroCliente = new TodoRiesgo(null, fechaInicio, vehiculo);
				break;
			case "TRFRANQUICIA":
				seguroCliente = new TRFranquicia(null, fechaInicio, vehiculo, precio);
				break;
			default:
				throw new IllegalArgumentException();

		}
		Seguro seguroClienteAsignado = seguroRepository.save(seguroCliente);
		
		c.getSeguros().add(seguroClienteAsignado);
		clienteRepository.save(c);
		
		return seguroClienteAsignado;
		
		
	}
	
	public Parte crearParteCliente (String dni, Long idSeguro, double importe, LocalDate fecha) {
		Cliente c = clienteRepository.findByDni(dni);
		if (c == null) {
			return null;
		}
		Optional<Seguro> seguroClienteOpt = seguroRepository.findById(idSeguro);
		if (seguroClienteOpt.isEmpty()) {
		    return null;
		}
		Seguro seguroCliente = seguroClienteOpt.get();
		if (!c.getSeguros().contains(seguroCliente)) {
			return null;
		}
		Parte parteSeguroCliente = new Parte(seguroCliente, importe, fecha, null);
		Parte parteAsignado = parteRepository.save(parteSeguroCliente);
		
		c.getPartes().add(parteAsignado);
		clienteRepository.save(c);
		
		return parteAsignado;
		
		
	}
}
