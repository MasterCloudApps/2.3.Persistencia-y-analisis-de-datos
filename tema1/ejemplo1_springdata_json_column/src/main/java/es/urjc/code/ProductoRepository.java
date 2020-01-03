package es.urjc.code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para productos.
 *
 *  @author J. Manuel Colmenar
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta por la marca del campo datos
    @Query("select p from Producto p where FUNCTION('JSON_EXTRACT',p.datos,'$.marca') = ?1")
    List<Producto> findByMarca(String marca);

    // Consulta por una etiqueta dada (hacen falta las comillas)
    @Query("select p from Producto p where FUNCTION('JSON_CONTAINS',p.datos, " +
           "CONCAT('\"',?1,'\"'),'$.etiquetas') = 1")
    List<Producto> findByEtiqueta(String etiqueta);
}
