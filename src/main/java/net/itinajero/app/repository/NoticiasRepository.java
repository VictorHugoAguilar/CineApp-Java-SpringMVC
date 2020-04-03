package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

	// Select * from noticias
	List<Noticia> findBy();

	// Select * from noticias where estatus = '?'
	List<Noticia> findByEstatus(String estatus);

	// Select * from noticias where fecha = ' ? '
	List<Noticia> findByFecha(Date fecha);

	// Select * from noticia where estatus = ? and fecha = ?
	List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);

	// Select * from noticia where estatus = ? or fecha = ?
	List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);

	// Select * from noticia where fecha between
	List<Noticia> findByFechaBetween(Date fechaDesde, Date fechaHasta);
	

	// Select * from noticia where id between - rango de id
	List<Noticia> findByIdBetween(int idDesde, int idHasta);

}
