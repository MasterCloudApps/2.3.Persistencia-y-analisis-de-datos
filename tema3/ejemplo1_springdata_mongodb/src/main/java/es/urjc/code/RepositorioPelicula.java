package es.urjc.code;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio MongoDB, similar a los definidos para SpringData.
 *
 * Al insertar elementos creará una colección en el servidor cuyo nombre
 * es el del objeto guardado.
 *
 * @author J. M. Colmenar
 */
public interface RepositorioPelicula extends MongoRepository<Pelicula, String> {

    // Método para buscar película por título
    public Pelicula findByTitulo(String titulo);

}
