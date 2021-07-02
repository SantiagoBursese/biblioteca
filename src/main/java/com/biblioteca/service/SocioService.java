package com.biblioteca.service;

import java.util.ArrayList;
import java.util.Optional;

import com.biblioteca.entities.Socio;

public interface SocioService {

	public ArrayList<Socio> obtenerSocios();
	public Socio guardarSocio(Socio socio);
	public Optional<Socio> buscarSocioPorId(Long id);
	public String borrarSocio(long id);
	public String actualizarSocio(Socio nuevoSocio);
}
