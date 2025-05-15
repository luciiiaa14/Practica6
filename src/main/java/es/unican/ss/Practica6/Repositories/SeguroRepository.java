package es.unican.ss.Practica6.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.ss.Practica6.domain.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

	public Optional<Seguro> findById(Long id);

}