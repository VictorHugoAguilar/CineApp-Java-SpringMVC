package pruebasCRUDRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Operacion CRUD - Delete [ Método deleteById luego update del repositorio ]

		int idNoticia = 3;

		// Si no existe una entidad con el id tenemos que hacer uso de un método de
		// comprobación

		if (repo.existsById(idNoticia)) {
			repo.deleteById(idNoticia);

		} else {
			System.err.println("No existe entidad en la BD");
		}

		context.close();
	}

}
