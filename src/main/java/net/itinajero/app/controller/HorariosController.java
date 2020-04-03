package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IHorariosService;
import net.itinajero.app.service.IPeliculaService;

@Controller
@RequestMapping(value = "/horarios")
public class HorariosController {

	@Autowired
	private IPeliculaService servicePeliculas;

	@Autowired
	private IHorariosService serviceHorarios;

	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * 
	 * @return
	 */
	@GetMapping(value = "/create")
	public String crear(Model model, @ModelAttribute Horario horario) {

		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();

		// Ejercicio: Recuperar lista de peliculas para poblar <select>
		model.addAttribute("peliculas", listaPeliculas);
		model.addAttribute("salas", nombreSalas());

		// Ejercicio: agregar al modelo listado de peliculas

		// Ejercicio: crear archivo formHorario.jsp y configurar el dise�o utilizando el
		// codigo HTML
		// del archivo formHorario.html de la plantilla (utilizar Form Tag Library)

		return "horarios/formHorario";
	}

	/**
	 * Metodo para guardar el registro del Horario
	 * 
	 * @param horario
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,
			RedirectAttributes redirectAttibute) {

		// Ejercicio: Verificar si hay errores en el Data Binding
		if (result.hasErrors()) {
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			model.addAttribute("salas", nombreSalas());

			return "horarios/formHorario";
		}
		// Ejercicio: En caso de no haber errores, imprimir en consola el objeto de
		// model Horario
		// que ya debera de tener los datos del formulario
		System.out.println(horario);

		Horario horarioInsertado = serviceHorarios.insertar(horario);
		String mensaje = horarioInsertado != null ? "Se ha insertado correctamente " : null;

		redirectAttibute.addFlashAttribute("mensaje", mensaje);

		// De momento, hacemos un redirect al mismo formulario
		return "redirect:/horarios/create";
	}

	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * 
	 * @param binder
	 */
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	private List<String> nombreSalas() {
		// Nota: Esto lo podriamos meter en una bd posteriori
		List<String> salas = new LinkedList<String>();
		salas.add("Sala Premium");
		salas.add("Sala 1");
		salas.add("Sala 2");
		salas.add("Sala 3");
		salas.add("Sala 4");

		return salas;
	}

}
