package pruebasCRUDRepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindByAllById {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para recuperar todas las entidades de una tabla [ findAllbyId del
		// repositorio ]

		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		
		Iterable<Noticia> noticias = repo.findAllById(ids);

		for (Noticia noti : noticias) {

			System.out.println(noti);

		}

		context.close();
	}
	
}
