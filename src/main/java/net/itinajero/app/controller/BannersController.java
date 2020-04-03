package net.itinajero.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Banner;
import net.itinajero.app.service.BannersServiceImpl;
import net.itinajero.app.util.Util;

@Controller
@RequestMapping("/banners")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio
	@Autowired
	private BannersServiceImpl serviceBanner;

	/**
	 * Metodo para mostrar el listado de banners
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		// Ejercicio: Implementar metodo
		List<Banner> listaBanner = serviceBanner.buscarTodos();

		model.addAttribute("banners", listaBanner);

		// Ejercicio: Crear vista listBanners.jsp. Utilizar el archivo listBanners.html
		// de la plantilla
		return "banners/listBanners";
	}

	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * 
	 * @return
	 */
	@GetMapping("/create")
	public String crear() {

		// Ejercicio: Crear vista formBanner.jsp. Utilizar el archivo formBanner.html de
		// la plantilla
		return "banners/formBanner";

	}

	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * 
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Banner banner, BindingResult result, RedirectAttributes redirectAttribute,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		System.out.println(new Date() + " [ CONTROLLER/GUARDAR ]" + banner);

		// Ejercicio: Implementar el metodo.

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "banners/formBanner";
		}

		// guardamos la imagen
		if (!multiPart.isEmpty()) {
			String nombreImagen = Util.guardarImagen(multiPart, request);
			banner.setArchivo(nombreImagen);
		}else {
			return "banners/formBanner";
		}

		// Almacenamos la imagen
		System.out.println(new Date() + " [ Almacenando ] " + banner);

		serviceBanner.insertar(banner);

		redirectAttribute.addFlashAttribute("mensaje", "Registro insertado correctamente");

		return "redirect:/banners/index";
	}
}
