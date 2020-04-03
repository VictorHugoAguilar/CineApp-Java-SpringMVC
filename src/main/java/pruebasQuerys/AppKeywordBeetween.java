package pruebasQuerys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordBeetween {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		/* Metodo FindAnd */

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date fechaDesde;
		Date fechaHasta;

		List<Noticia> listaNoticiasEstatusActivas = null;

		try {
			fechaDesde = format.parse("2017-09-01");
			fechaHasta = format.parse("2017-09-02");

			System.out.println(fechaDesde);
			System.out.println(fechaHasta);

			// listaNoticiasEstatusActivas = repo.findByFechaBetween(fechaDesde,
			// fechaHasta);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		listaNoticiasEstatusActivas = repo.findByIdBetween(0, 12);

		for (Noticia noticia : listaNoticiasEstatusActivas) {

			System.out.println(noticia);

		}

		context.close();
	}

}
