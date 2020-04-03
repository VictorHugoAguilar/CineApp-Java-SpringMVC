package pruebasQuerys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordOr {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		/* Metodo FindAnd */

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fecha;
		List<Noticia> listaNoticiasEstatusActivas = null;

		try {
			fecha = format.parse("2017-09-01");

			System.out.println(fecha);

			listaNoticiasEstatusActivas = repo.findByEstatusOrFecha("Inactiva", fecha);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (Noticia noticia : listaNoticiasEstatusActivas) {

			System.out.println(noticia);

		}

		context.close();
	}

}
