package com.biblioteca.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.biblioteca.entities.Socio;

public interface SocioController {

	public ArrayList<Socio> obtenerSocios();
	
	public Optional<Socio> obtenerSocioPorId(Long id);
	
	public Socio guardarSocio (Socio socio);
	
	public String borrarSocio(Long id);
	
	public String actualizarSocio(Socio nuevoSocio);
}
