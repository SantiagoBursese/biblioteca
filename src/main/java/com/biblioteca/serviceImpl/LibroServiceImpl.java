package com.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entities.Libro;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroRepository libroRepository;
	
	public ArrayList<Libro> obtenerLibros(){
		return (ArrayList<Libro>) libroRepository.findAll();
	}
	
	public Libro guardarLibro(Libro libro) {
		if(libro != null) {
			return libroRepository.save(libro);
		}
		return new Libro();
	}

	@Override
	public Optional<Libro> buscarLibroPorId(Long id) {
		Optional<Libro> libro = libroRepository.findById(id);
		return libro;
	}

	@Override
	public String borrarLibro(long id) {
		if(libroRepository.findById(id).isPresent()) {
			libroRepository.deleteById(id);
			return "Libro eliminado correctamente";
		}
		return "Error! el libro no existe";
	}

	@Override
	public String actualizarLibro(Libro nuevoLibro) {
		Long num = nuevoLibro.getCodigo();
		if(libroRepository.findById(num).isPresent()) {
			Libro libroAActualizar = new Libro();
			libroAActualizar.setCodigo(nuevoLibro.getCodigo());
			libroAActualizar.setNombre(nuevoLibro.getNombre());
			libroAActualizar.setAutor(nuevoLibro.getAutor());
			libroAActualizar.setEditorial(nuevoLibro.getEditorial());
			libroAActualizar.setGenero(nuevoLibro.getGenero());
			libroRepository.save(libroAActualizar);
			return "Libro modificado";
		}
		return "Error al modificar el libro";
		
		
	}
	
} 
