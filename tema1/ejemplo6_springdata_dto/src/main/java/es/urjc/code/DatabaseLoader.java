package es.urjc.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void run(String... args) throws ParseException {

        // Guardando datos ...
        Producto p1 = new Producto("Apple Macbook");
        List<Version> versiones = new ArrayList<>();
        versiones.add(new Version("1.0",new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2015"),p1));
        versiones.add(new Version("1.5",new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2015"),p1));

        p1.setVersiones(versiones);
        productoRepository.save(p1);

        Producto p2 = new Producto("IBM PC");
        List<Version> versiones2 = new ArrayList<>();
        versiones2.add(new Version("1.0",new SimpleDateFormat("dd/MM/yyyy").parse("12/08/1981"),p2));
        p2.setVersiones(versiones2);
        productoRepository.save(p2);

        // Recupera productos
        List<Producto> productos = productoRepository.findAll();
        System.out.println("Productos con findAll():");
        System.out.println("------------------------------------------");
        productos.forEach(System.out::println);


        // Implementación con JPQL -------------------------------------------------------

        // Proyección
        List<ProductoDTO> proy = productoRepository.findProductoProjection();
        System.out.println("ProductoDTO:");
        System.out.println("------------------------------------------");
        proy.forEach(System.out::println);

        // Proyección agregada
        List<ProductoDTO> stats = productoRepository.findProductoNumVersiones();
        System.out.println("ProductoDTO y número:");
        System.out.println("------------------------------------------");
        stats.forEach(System.out::println);


        // Implementación con query nativa  --------------------------------------------------

        // Proyección
        List<IProductoDTO> proy2 = productoRepository.findProductoProjectionInterface();
        System.out.println("ProductoDTO (nativa con interfaz):");
        System.out.println("------------------------------------------");
        proy2.forEach(p -> System.out.println("Producto: '"+p.getDatos()+"'"));

        // Proyección agregada
        List<IProductoDTO> stats2 = productoRepository.findProductoNumVersionesInterface();
        System.out.println("ProductoDTO y número (nativa con interfaz):");
        System.out.println("------------------------------------------");
        stats2.forEach(p -> System.out.println("Producto: '"+p.getDatos()+"', Versiones: "+p.getNumero()));

    }

}
