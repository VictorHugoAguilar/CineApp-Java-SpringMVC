package pruebasCRUDRepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppRead {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Operacion CRUD - Read [ Método findById del repositorio ]
		
		Optional<Noticia> noticia = repo.findById(2);
		
		System.out.println(noticia);

		System.out.println(noticia.get());
		
		context.close();
	}

}
