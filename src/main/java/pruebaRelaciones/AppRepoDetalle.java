package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

public class AppRepoDetalle {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		// Recuperammos todas las entidades de tipo Pelicula
		DetallesRepository repo = context.getBean("detallesRepository", DetallesRepository.class);

		List<Detalle> lista = repo.findAll();

		for (Detalle detalle : lista) {
			System.out.println(detalle);
		}

		
		context.close();
	}

}
