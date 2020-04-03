package pruebasJPARepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para recuperar todas las entidades de una tabla [ deleteAllInBatch ]
		// Este es más eficiente

		// !! IMPORTANTE ES PELIGROSO
		repo.deleteAllInBatch();

		context.close();
	}

}
