package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.Horario;

public interface IHorariosService {

	Horario insertar(Horario horario);
	
	List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);

}
