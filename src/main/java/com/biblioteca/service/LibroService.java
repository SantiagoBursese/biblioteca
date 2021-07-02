package com.biblioteca.service;

import java.util.ArrayList;
import java.util.Optional;

import com.biblioteca.entities.Libro;

public interface LibroService {

	public ArrayList<Libro> obtenerLibros();
	public Libro guardarLibro(Libro libro);
	public Optional<Libro> buscarLibroPorId(Long id);
	public String borrarLibro(long id);
	public String actualizarLibro(Libro nuevoLibro);
}
