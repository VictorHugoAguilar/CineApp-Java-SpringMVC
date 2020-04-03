package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.util.Util;
import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IHorariosService;
import net.itinajero.app.service.IPeliculaService;

@Controller
public class HomeController {

	@Autowired
	private IPeliculaService servicePeliculas;

	@Autowired
	private IBannersService serviceBanners;

	@Autowired
	private IHorariosService serviceHorarios;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Util.getNextDays(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		List<Banner> banners = serviceBanners.buscarTodos();

		// peliculas.add("El vengador");
		model.addAttribute("anio", dateYear.format(new Date()));
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banners);

		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		System.out.println(fecha);

		List<String> listaFechas = Util.getNextDays(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		List<Banner> banners = serviceBanners.buscarTodos();

		model.addAttribute("anio", dateYear.format(new Date()));
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("listaFechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banners);

		return "home";
	}

	/*
	 * @RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	 * public String mostarDetalle(Model model, @PathVariable("id") int
	 * idPelicula, @PathVariable("fecha") String fechaBusqueda) {
	 * 
	 * System.out.println("idPelicula: " + idPelicula);
	 * System.out.println("fechaBusqueda: " + fechaBusqueda);
	 * 
	 * return "detail";
	 * 
	 * }
	 */

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostarDetalle(Model model, @RequestParam("idMovie") int idPelicula,
			@RequestParam("fecha") Date fechaBusqueda) {

		List<Horario> listaHorarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fechaBusqueda);

		model.addAttribute("horarios", listaHorarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fechaBusqueda));
		model.addAttribute("anio", dateYear.format(new Date()));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));

		return "detalle";

	}

	// Para personalizar el binder de la fecha
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

}
