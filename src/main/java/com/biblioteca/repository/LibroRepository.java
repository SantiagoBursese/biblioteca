package com.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entities.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{

	Void save(Optional<Libro> libroParaActualizar);
}
