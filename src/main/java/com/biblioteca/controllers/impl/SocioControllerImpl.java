package com.biblioteca.controllers.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.controllers.SocioController;
import com.biblioteca.entities.Socio;
import com.biblioteca.service.SocioService;

@RestController
public class SocioControllerImpl implements SocioController{

	@Autowired
	SocioService socioService;
	
	@RequestMapping(value ="/socio", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Socio> obtenerSocios(){
		return socioService.obtenerSocios();
	}
	
	@RequestMapping(value = "/socio", method = RequestMethod.POST, produces ="application/json")
	public Socio guardarSocio(@RequestBody Socio socio) {
		return this.socioService.guardarSocio(socio);
	}

	@RequestMapping(value = "/socio/{id}", method = RequestMethod.GET, produces ="application/json")
	public Optional<Socio> obtenerSocioPorId(@PathVariable Long id) {
		return socioService.buscarSocioPorId(id);
	}

	@RequestMapping(value = "/socio/{id}", method = RequestMethod.DELETE, produces ="application/json")
	public String borrarSocio(@PathVariable Long id) {
		return socioService.borrarSocio(id);
	}

	@RequestMapping(value = "/socio", method = RequestMethod.PATCH, produces ="application/json")
	public String actualizarSocio(@RequestBody Socio nuevoSocio) {
		return socioService.actualizarSocio(nuevoSocio);
	}


}
