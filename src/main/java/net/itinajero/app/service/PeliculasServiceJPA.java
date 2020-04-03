package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

/**
 * Clase para manejar las entidades desde la BD del tipo Pelicula
 * 
 * @author victorhugo
 */

@Service
public class PeliculasServiceJPA implements IPeliculaService {

	@Autowired
	private PeliculasRepository peliculasRepository;

	public void insertar(Pelicula pelicula) {

		peliculasRepository.save(pelicula);

	}

	public List<Pelicula> buscarTodas() {

		return peliculasRepository.findAll();

	}

	public Pelicula buscarPorId(int idPelicula) {

		Optional<Pelicula> pelicula = peliculasRepository.findById(idPelicula);

		if (pelicula.isPresent()) {
			return pelicula.get();
		}

		return null;
	}

	public void eliminar(int idPelicula) {

		peliculasRepository.deleteById(idPelicula);

	}

	public Page<Pelicula> buscarTodas(Pageable page) {

		return peliculasRepository.findAll(page);
		
	}

}
