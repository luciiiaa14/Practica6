package es.unican.ss.Practica6.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.unican.ss.Practica6.DTO.NuevoParteDTO;
import es.unican.ss.Practica6.DTO.NuevoSeguroDTO;
import es.unican.ss.Practica6.domain.Cliente;
import es.unican.ss.Practica6.domain.Parte;
import es.unican.ss.Practica6.domain.Seguro;
import es.unican.ss.Practica6.service.IAseguradoraService;

@RestController
@RequestMapping("/aseguradora/clientes")
public class AseguradoraController {
	private IAseguradoraService aseguradoraService;
	
	public AseguradoraController(IAseguradoraService service) {
		this.aseguradoraService = service;
	}
	
	//Obtención de todos los clientes.
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes  = aseguradoraService.clientes();
		return ResponseEntity.ok(clientes);
	}
	
	//Obtener un cliente.
	@GetMapping("/{dni}")
	public ResponseEntity<Cliente> getCliente(@PathVariable String dni) {
		Cliente c = aseguradoraService.clientePorDNI(dni);
		if (c != null) {
			return ResponseEntity.ok(c);	
		}
		return ResponseEntity.notFound().build();
	}
	
	//Crear un cliente.
	@PutMapping("/{dni}")
	public ResponseEntity<Cliente> creaCliente (@RequestBody Cliente c, @PathVariable String dni) {
		Cliente creado = aseguradoraService.creaCliente(c);
		if (creado == null) 
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(creado);
	}
	
	//Obtener un importe del cliente.
	@GetMapping("/{dni}/importe")
	public ResponseEntity<Double> obtenerImporteCliente (@PathVariable String dni){
		Double importe = aseguradoraService.obtenerImporteCliente(dni);
		if (importe != null) {
			return ResponseEntity.ok(importe);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	//Crear un seguro para un cliente.
	@PutMapping("/{dni}/seguros/seguro")
	public ResponseEntity<Seguro> crearSeguroCliente (@PathVariable String dni, @RequestBody NuevoSeguroDTO nuevoSeguroDTO) {	
		Seguro seguro = aseguradoraService.crearSeguroCliente(dni, nuevoSeguroDTO.getTipoSeguro(),
				nuevoSeguroDTO.getFechaInicio(), nuevoSeguroDTO.getVehiculo(), nuevoSeguroDTO.getPrecio());
		
		if (seguro == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(seguro);
		
	}
	
	//Asociar un parte a un cliente.
	@PutMapping("/{dni}/seguros/seguro/partes/parte")
	public ResponseEntity<Parte> crearParteCliente (@PathVariable String dni, @RequestBody NuevoParteDTO nuevoParteDTO) {
		
		if (nuevoParteDTO.getIdSeguro() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		Parte parte = aseguradoraService.crearParteCliente(dni, nuevoParteDTO.getIdSeguro(), 
				nuevoParteDTO.getImporte(), nuevoParteDTO.getFecha());
		if (parte == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(parte);
		
	}
}
