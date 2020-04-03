package pruebasJPARepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para recuperar y ordenar las entidades de la tabla [ Sort ]

		// List<Noticia> noticias = repo.findAll(Sort.by("titulo").descending()) 

		// Método para recuperar y ordenar las entidades de la tabla [ Sort().and( Sort() ) ] y otro atributo;
		
		List<Noticia> noticias = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));

		for (Noticia noti : noticias) {

			System.out.println(noti);

		}

		context.close();
	}

}
