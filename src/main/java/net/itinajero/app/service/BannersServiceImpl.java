package net.itinajero.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Banner;

@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> lista = null;

	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	@SuppressWarnings("deprecation")
	public BannersServiceImpl() {

		System.out.println(
				new Date().toLocaleString() + " [SERVICE] Creando una instancia de la clase BannersServiceImpl");

		// Ejercicio: Crear una nueva lista enlazada
		try {
			lista = new LinkedList<Banner>();

			// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)
			Banner banner1 = new Banner();
			banner1.setId((int) new Date().getTime());
			banner1.setTitulo("Slider 1");
			banner1.setArchivo("slide1.jpg");

			Banner banner2 = new Banner();
			banner2.setId((int) new Date().getTime());
			banner2.setTitulo("Slider 2");
			banner2.setArchivo("slide2.jpg");

			Banner banner3 = new Banner();
			banner3.setId((int) new Date().getTime());
			banner3.setTitulo("Slider 3");
			banner3.setArchivo("slide3.jpg");

			Banner banner4 = new Banner();
			banner4.setId((int) new Date().getTime());
			banner4.setTitulo("Slider 4");
			banner4.setArchivo("slide4.jpg");

			// Ejercicio: Agregar los objetos Banner a la lista
			lista.add(banner1);
			lista.add(banner2);
			lista.add(banner3);
			lista.add(banner4);

		} catch (Exception e) {
			System.err.println(new Date() + " [ERROR class BannersServiceImpl ] " + e.getMessage());
		}

	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	public void insertar(Banner banner) {
		// Generamos el id único
		banner.setId((int) new Date().getTime());
		// Ejercicio: Implementar metodo
		lista.add(banner);

	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	public List<Banner> buscarTodos() {

		// Ejercicio: Implementar metodo
		return lista;

	}

}
