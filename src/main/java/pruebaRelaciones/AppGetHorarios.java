package pruebaRelaciones;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

public class AppGetHorarios {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		// Recuperammos todas las entidades de tipo Pelicula
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);

		Optional<Pelicula> lista = repo.findById(2);

		System.out.println(lista.get().getHorarios().size());
		
		context.close();
		
	}

}
