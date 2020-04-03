package pruebasCRUDRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para contar nuestras entidades ( count() )

		Long numeroEntidades = repo.count();

		System.out.println("Se encontraron " + numeroEntidades + " registros");

		context.close();
	}

}
