package es.urjc.code;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Entidad a guardar en MongoDB, no se etiqueta con @Entity.
 * 
 * @author J. M. Colmenar
 *
 */
public class Pelicula {

	/* - La anotación @Id es necesaria para la BD en Mongo.
       - Ojo porque id es ** String ** !!  -> Necesario para que MongoDB lo utilice
         correctamente como clave.
    */
	@Id
	private String id;
	private String titulo;
	private int anio;
	private String imdb;
	private List<Actor> actores;

	// Constructor vacío necesario para Spring
	public Pelicula() {
	}
	
	public Pelicula(String titulo, int anio, String imdb) {
		this.titulo = titulo;
		this.anio = anio;
		this.imdb = imdb;
	}

	public Pelicula(String titulo, int anio, String imdb, List<Actor> actores) {
		this.titulo = titulo;
		this.anio = anio;
		this.imdb = imdb;
		this.actores = actores;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}

	@Override
    public String toString() {
        return String.format(
                "Pelicula[id=%s, titulo='%s', anio='%s', imdb='%s', actores='%s']",
                id, titulo, anio, imdb, actores);
    }

	
}
