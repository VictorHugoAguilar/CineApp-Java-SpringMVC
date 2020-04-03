package pruebasJPARepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Método para recuperar y paginar las entidades de la tabla [ PageRequest ]
		// Page<Noticia> noticias = repo.findAll(PageRequest.of(1, 5));

		// Método para recuperar y paginar las entidades de la tabla paginacion [
		// PageRequest ]
		Page<Noticia> noticias = repo.findAll(PageRequest.of(0, 10, Sort.by("titulo")));

		for (Noticia noti : noticias) {
			System.out.println(noti);
		}

		context.close();
	}
}
