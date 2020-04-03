package pruebaRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

public class AppRepoHorario {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		// Recuperammos todas las entidades de tipo Pelicula
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);

		List<Horario> lista = repo.findAll();

		for (Horario horario : lista) {
			System.out.println(horario);
		}
		context.close();
	}

}
