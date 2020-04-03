package pruebasCRUDRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppfindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para recuperar todas las entidades de una tabla [ findAll del
		// repositorio ]

		Iterable<Noticia> noticias = repo.findAll();

		for (Noticia noti : noticias) {

			System.out.println(noti);

		}

		context.close();
	}

}
