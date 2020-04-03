package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.service.IGenerosServiceJPA;

@Controller
public class ContactoController {

	private SimpleDateFormat dateYear = new SimpleDateFormat("yyyy");

	@Autowired
	private IGenerosServiceJPA serviceGeneros;

	@GetMapping("/contacto")
	public String mostrarFormulario(Model model, @ModelAttribute Contacto contacto) {

		model.addAttribute("anio", dateYear.format(new Date()));
		model.addAttribute("generos", serviceGeneros.buscarDetalles());
		model.addAttribute("notifications", tipoNotificaciones());

		return "formContacto";
	}

	@PostMapping("/contacto")
	public String guardar(@ModelAttribute Contacto contacto, Model model) {

		System.out.println(contacto);

		return "redirect:/contacto";
	}

	private List<String> tipoNotificaciones() {
		// Nota: Esto lo podriamos meter en una bd posteriori
		List<String> tipos = new LinkedList<String>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Eventos");
		tipos.add("Pre-Ventas");

		return tipos;
	}

}
