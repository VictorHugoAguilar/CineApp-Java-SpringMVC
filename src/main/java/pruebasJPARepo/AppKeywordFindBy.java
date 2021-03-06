package pruebasJPARepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordFindBy {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		
		
		
		List<Noticia> noticias = repo.findAll();

		for (Noticia noti : noticias) {

			System.out.println(noti);

		}

		context.close();
	}
	
}
