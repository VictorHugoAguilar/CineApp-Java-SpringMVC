package net.itinajero.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "director")
	private String director;

	@Column(name = "actores")
	private String actores;

	@Column(name = "sinopsis")
	private String sinopsis;

	@Column(name = "trailer")
	private String trailer;

	/**
	 * Constructor de la clase
	 */
	public Detalle() {
	}

	/**
	 * Getter and Setter
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	/**
	 * Sobrescribimos el toString para que nos devuelva el objeto completo
	 */
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", director=" + director + ", actores=" + actores + ", sinopsis=" + sinopsis
				+ ", trailer=" + trailer + "]";
	}

}
