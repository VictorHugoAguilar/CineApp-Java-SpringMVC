package pruebasCRUDRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {

		Noticia noticia = new Noticia();
		noticia.setTitulo("La Bella y la Bestia - La Pelicula");
		noticia.setDetalle("Se acerca el nuevo estreno de la version real de la peli animada");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Operacion CRUD - Create [ Método save del repositorio ]

		repo.save(noticia);

		context.close();
	}

}
