package com.biblioteca.serviceImpl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entities.Socio;
import com.biblioteca.repository.SocioRepository;
import com.biblioteca.service.SocioService;

@Service
public class SocioServiceImpl implements SocioService{

	@Autowired
	SocioRepository socioRepository;
	
	public ArrayList<Socio> obtenerSocios(){
		return (ArrayList<Socio>) socioRepository.findAll();
	}
	
	public Socio guardarSocio(Socio socio) {
		if(socio != null) {
			return socioRepository.save(socio);
		}
		return new Socio();
	}

	@Override
	public Optional<Socio> buscarSocioPorId(Long id) {
		Optional<Socio> socio = socioRepository.findById(id);
		return socio;
	}

	@Override
	public String borrarSocio(long id) {
		if(socioRepository.findById(id).isPresent()) {
			socioRepository.deleteById(id);
			return "Socio eliminado correctamente";
		}
		return "Error! el socio no existe";
	}

	@Override
	public String actualizarSocio(Socio nuevoSocio) {
		Long num = nuevoSocio.getCodigo();
		if(socioRepository.findById(num).isPresent()) {
			Socio socioAActualizar = new Socio();
			socioAActualizar.setCodigo(nuevoSocio.getCodigo());
			socioAActualizar.setNombre(nuevoSocio.getNombre());
			socioAActualizar.setApellido(nuevoSocio.getApellido());
			socioAActualizar.setDni(nuevoSocio.getDni());
			socioAActualizar.setTelefono(nuevoSocio.getTelefono());
			socioRepository.save(socioAActualizar);
			return "Socio modificado";
		}
		return "Error al modificar el socio";
		
		
	}
	
} 
