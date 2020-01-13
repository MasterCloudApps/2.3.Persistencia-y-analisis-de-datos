package es.urjc.code.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio.
 *
 *  @author J. Manuel Colmenar
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

}
