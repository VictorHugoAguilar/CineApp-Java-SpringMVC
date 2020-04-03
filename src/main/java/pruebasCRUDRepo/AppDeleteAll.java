package pruebasCRUDRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para  eliminar todo el registro de una tabla [ deleteAll ] !! PELIGROSO
		
		if(repo.count() > 0) {
			
			repo.deleteAll();

		}
		
		
		context.close();
		
	}

}
