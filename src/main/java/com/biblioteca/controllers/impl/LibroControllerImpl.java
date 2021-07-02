package com.biblioteca.controllers.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.controllers.LibroController;
import com.biblioteca.entities.Libro;
import com.biblioteca.service.LibroService;

@RestController
public class LibroControllerImpl implements LibroController{

	@Autowired
	LibroService libroService;
	
	@RequestMapping(value ="/libro", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Libro> obtenerLibros(){
		return libroService.obtenerLibros();
	}
	
	@RequestMapping(value = "/libro", method = RequestMethod.POST, produces ="application/json")
	public Libro guardarLibro(@RequestBody Libro libro) {
		return this.libroService.guardarLibro(libro);
	}

	@RequestMapping(value = "/libro/{id}", method = RequestMethod.GET, produces ="application/json")
	public Optional<Libro> obtenerLibroPorId(@PathVariable Long id) {
		return libroService.buscarLibroPorId(id);
	}

	@RequestMapping(value = "/libro/{id}", method = RequestMethod.DELETE, produces ="application/json")
	public String borrarLibro(@PathVariable Long id) {
		return libroService.borrarLibro(id);
	}

	@RequestMapping(value = "/libro", method = RequestMethod.PATCH, produces ="application/json")
	public String actualizarLibro(@RequestBody  Libro nuevoLibro) {
		return libroService.actualizarLibro(nuevoLibro);
	}
}
