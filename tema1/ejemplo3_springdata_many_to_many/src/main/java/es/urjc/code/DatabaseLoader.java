package es.urjc.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

/**
 * Cargador de la BD.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public void run(String... args) {

        // Guardando datos ...
        Empleado e1 = new Empleado("Juan");
        Proyecto p1 = new Proyecto("Proy 1");
        Proyecto p2 = new Proyecto("Proy 2");
        Proyecto p3 = new Proyecto("Proy 3");

        List<Proyecto> proyectos = new ArrayList<>();
        proyectos.add(p1);
        proyectos.add(p2);
        proyectos.add(p3);

        e1.setProyectos(proyectos);
        empleadoRepository.save(e1);

        // Borrado de datos
        e1.getProyectos().remove(p2);
        empleadoRepository.save(e1);

        // Inversión de los datos
        e1.getProyectos().sort(Collections.reverseOrder(Comparator.comparing(Proyecto::getId)));
        empleadoRepository.save(e1);

    }

}
