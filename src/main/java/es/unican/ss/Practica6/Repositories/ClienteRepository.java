package es.unican.ss.Practica6.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.ss.Practica6.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByDni(String dni);

}

