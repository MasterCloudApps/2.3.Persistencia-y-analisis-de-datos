package es.urjc.code.single;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio.
 *
 *  @author J. Manuel Colmenar
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // Consulta por la marca del campo datos
    @Query(value = "select * from Jugador where dtype = 'Golfista'",nativeQuery = true)
    List<Golfista> findGolfistas();

}
