package net.itinajero.app.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService {

	@SuppressWarnings("deprecation")
	public NoticiasServiceImpl() {
		System.out.println(new Date().toLocaleString() + " [SERVICE] Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	public void guardar(Noticia noticia) {
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
	}

	
}
