package es.unican.ss.Practica6.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.ss.Practica6.domain.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

	public Seguro findBySeguro(Seguro seguro);

}