package pruebasCRUDRepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		// Operacion CRUD - Update [ Método findById luego update del repositorio ]

		// 1.Primero buscamos la entidad que vamos a modificar. (findByid)

		Optional<Noticia> noticia = repo.findById(2);

		// 2. Modificamos si es encotrado el objeto

		if (noticia.isPresent()) {

			Noticia noticiaUpdate = noticia.get();

			System.out.println(noticia.get());

			noticiaUpdate.setTitulo("Estreno de SAW 8, proximamente");
			noticiaUpdate.setEstatus("Inactiva");

			// 3. grabamos ahora en el rep esto lo hace automáticamente revisando si tiene
			// valor el id

			repo.save(noticiaUpdate);
		}

		context.close();
	}

}
