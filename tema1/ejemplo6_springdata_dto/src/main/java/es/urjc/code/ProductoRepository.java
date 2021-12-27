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

    // Consultas JPQL

    @Query("select new es.urjc.code.ProductoDTO(p.datos) from Producto p")
    List<ProductoDTO> findProductoProjection();

    @Query("select new es.urjc.code.ProductoDTO(p.datos,count(p))" +
            " from Producto p join Version v on v.producto = p" +
            " group by p.datos")
    List<ProductoDTO> findProductoNumVersiones();


    // Consulta nativa (requiere interfaz)

    @Query(value = "select p.datos as datos from producto p", nativeQuery = true)
    List<IProductoDTO> findProductoProjectionInterface();


    @Query(value = "select p.datos as datos, count(*) as numero" +
           " from producto p join version v on p.id = v.producto_id" +
           " group by p.datos", nativeQuery = true)
    List<IProductoDTO> findProductoNumVersionesInterface();


}
