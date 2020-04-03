package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;

import net.itinajero.app.model.Pelicula;

// @Service
public class PeliculasServiceImpl implements IPeliculaService {
	private List<Pelicula> lista = null;

	public PeliculasServiceImpl() {

		System.out.println(new Date() + " [SERVICE] Creando una instancia de la clase ServicePelicula");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy");

		try {
			lista = new LinkedList<Pelicula>();

			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(123);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			pelicula1.setImagen("estreno8.png");
			pelicula1.setEstatus("Inactiva");

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("La Bella y la Bestia");
			pelicula5.setDuracion(93);
			pelicula5.setClasificacion("A");
			pelicula5.setGenero("Aventura");
			pelicula5.setFechaEstreno(formatter.parse("12-05-2015"));
			pelicula5.setImagen("bella.png");
			// pelicula1.setEstatus();

			Pelicula pelicula6 = new Pelicula();
			pelicula6.setId(6);
			pelicula6.setTitulo("King Kong");
			pelicula6.setDuracion(93);
			pelicula6.setClasificacion("C");
			pelicula6.setGenero("Accion");
			pelicula6.setFechaEstreno(formatter.parse("14-04-2014"));
			pelicula6.setImagen("kong.png");
			// pelicula1.setEstatus();

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("El señor de los anillos");
			pelicula2.setDuracion(133);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Aventura");
			pelicula2.setFechaEstreno(formatter.parse("03-03-2015"));
			// pelicula2.setImagen();
			pelicula2.setEstatus("Inactiva");

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Matrix");
			pelicula3.setDuracion(113);
			pelicula3.setClasificacion("A");
			pelicula3.setGenero("Acción");
			pelicula3.setFechaEstreno(formatter.parse("12-12-2000"));
			// pelicula3.setImagen();
			// pelicula3.setEstatus();

			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Avenger");
			pelicula4.setDuracion(143);
			pelicula4.setClasificacion("A");
			pelicula4.setGenero("Acción");
			pelicula4.setFechaEstreno(formatter.parse("22-05-2018"));
			// pelicula4.setImagen();
			// pelicula4.setEstatus();

			Pelicula pelicula7 = new Pelicula();
			pelicula7.setId(7);
			pelicula7.setTitulo("Contratiempo");
			pelicula7.setDuracion(143);
			pelicula7.setClasificacion("A");
			pelicula7.setGenero("Acción");
			pelicula7.setFechaEstreno(formatter.parse("22-05-2018"));
			pelicula7.setImagen("contratiempo.png");
			// pelicula4.setEstatus();

			Pelicula pelicula8 = new Pelicula();
			pelicula8.setId(8);
			pelicula8.setTitulo("Guardianes de la Galaxia");
			pelicula8.setDuracion(111);
			pelicula8.setClasificacion("A");
			pelicula8.setGenero("Acción");
			pelicula8.setFechaEstreno(formatter.parse("22-12-2013"));
			pelicula8.setImagen("estreno10.png");
			// pelicula4.setEstatus();

			// Añadimos las peliculas a la lista
			lista.add(pelicula1);
			lista.add(pelicula4);
			lista.add(pelicula5);
			lista.add(pelicula2);
			lista.add(pelicula6);
			lista.add(pelicula3);
			lista.add(pelicula7);
			lista.add(pelicula8);

		} catch (Exception e) {
			System.err.println(new Date() + " [ERROR class PeliculasServiceImpl ] " + e.getMessage());
		}
	}

	public List<Pelicula> buscarTodas() {
		return this.lista;
	}

	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p : lista) {
			if (p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
	}

	public List<String> buscarGeneros() {

		// Nota: Esta lista luego la introduciremos en la BD
		List<String> generos = new LinkedList<String>();

		generos.add("Acción");
		generos.add("Aventura");
		generos.add("Clásica");
		generos.add("Comédia");
		generos.add("Comédia Romántica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Suspenso");
		generos.add("Acción y Aventura");
		generos.add("Romántica");
		generos.add("Ciencia Ficción");

		return generos;

	}

	public void eliminar(int idPelicula) {
		// TODO Auto-generated method stub

	}

	public Page<Pelicula> buscarTodas(org.springframework.data.domain.Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
