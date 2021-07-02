package com.biblioteca.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.biblioteca.entities.Libro;

public interface LibroController {

	public ArrayList<Libro> obtenerLibros();
	
	public Optional<Libro> obtenerLibroPorId(Long id);
	
	public Libro guardarLibro (Libro libro);
	
	public String borrarLibro(Long id);
	
	public String actualizarLibro(Libro nuevoLibro);
}
