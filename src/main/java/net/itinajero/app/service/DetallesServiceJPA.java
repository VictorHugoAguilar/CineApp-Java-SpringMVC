package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {

	@Autowired
	private DetallesRepository detallesRepository;

	public void insertar(Detalle detalle) {

		detallesRepository.save(detalle);

	}

	public void eliminar(int idDetalle) {

		detallesRepository.deleteById(idDetalle);

	}

}
