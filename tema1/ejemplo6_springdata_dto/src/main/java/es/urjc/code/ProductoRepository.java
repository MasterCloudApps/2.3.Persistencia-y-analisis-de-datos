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

    @Query("select new es.urjc.code.ProductoDTO(p.datos) from Producto p")
    List<ProductoDTO> findProductoProjection();

    @Query(value = "select new es.urjc.code.ProductoDTO(p.datos,count(p)) from Producto p join Version v on v.producto = p group by p.datos")
    List<ProductoDTO> findProductoNumVersiones();


}
