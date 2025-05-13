package es.unican.ss.Practica6.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.unican.ss.Practica6.domain.Parte;

public interface ParteRepository extends JpaRepository<Parte, Long> {

	public Parte findByParte(Parte parte);

}


