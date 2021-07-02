package com.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entities.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long>{

	Void save(Optional<Socio> libroParaActualizar);
}
