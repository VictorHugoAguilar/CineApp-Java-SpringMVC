package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService {

	@Autowired
	private HorariosRepository horarioServices;

	public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {

		return horarioServices.findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);

	}

	public Horario insertar(Horario horario) {

		Horario horarioInsertado = horarioServices.save(horario);

		return horarioInsertado != null ? horarioInsertado : null;

	}

}
