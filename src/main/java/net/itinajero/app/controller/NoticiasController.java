package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	/**
	 * Intanciamos la clase de serviceNoticias con el 
	 * autowired hace una injección de dependencias.
	 */
	@Autowired
	private INoticiasService serviceNoticias;

	/**
	 * Método que devuelve la vista con el formulario para crear
	 * una noticia.
	 * @return view
	 */
	@GetMapping(value = "/create")
	public String crear() {

		return "noticias/formNoticia";
	}

	/**
	 * Método que obtenemos los datos del formulario 
	 * los datos del formulario los name deben corresponder
	 * a las propiedades que tienen la clase bean Noticia
	 * es decir si el name del formulario del titulo
	 * la clase Noticia debe tener una propiedad y sus getter
	 * y setter para hacer el bindind. noticia.setTitulo();
	 * @param Noticia noticia
	 * @return view
	 */
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia) {
		// Pendiente: guardar el objeto noticia en la BD
		serviceNoticias.guardar(noticia);

		return "noticias/formNoticia";
	}
	
	/**
	 * Método utilizando los RequestParams() para obtener los datos desde el form
	 * utiliza los name de los elementos del form que tienen que ser los mismos que
	 * introducimos en los parametros de entrada.
	 * 
	 * @param titulo, estatus, detalle
	 * @return
	 */
	/*
	 * @PostMapping(value = "/save") public String guardar(@RequestParam("titulo")
	 * String titulo, @RequestParam("estatus") String estatus,
	 * 
	 * @RequestParam("detalle") String detalle) {
	 * 
	 * Noticia noticia = new Noticia(); noticia.setTitulo(titulo);
	 * noticia.setEstatus(estatus); noticia.setDetalle(detalle);
	 * 
	 * // Pendiente: guardar el objeto noticia en la BD
	 * serviceNoticias.guardar(noticia);
	 * 
	 * return "noticias/formNoticia"; }
	 */

	
}
