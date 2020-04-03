package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Genero;
import net.itinajero.app.repository.GenerosRepository;

@Service
public class GeneroServiceJPA implements IGenerosServiceJPA {

	@Autowired
	private GenerosRepository generoRepository;

	public List<Genero> buscarTodas() {

		return generoRepository.findAll();

	}

	@SuppressWarnings("null")
	public List<String> buscarDetalles() {
		List<Genero> generos = generoRepository.findAll();

		List<String> listaDescripcionGeneros = new LinkedList<String>();

		for (Genero genero : generos) {

			listaDescripcionGeneros.add(genero.getDescripcion());

		}

		return listaDescripcionGeneros;
	}

}
