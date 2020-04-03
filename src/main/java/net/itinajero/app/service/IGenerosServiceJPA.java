package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Genero;

public interface IGenerosServiceJPA {

	List<Genero> buscarTodas();
	
	List<String> buscarDetalles();

}
