package es.urjc.code;

import java.util.ArrayList;
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

    @Autowired
    private EmpleadoProyectoRepository empleadoProyectoRepository;

    @Override
    public void run(String... args) {

        // Guardando datos ...
        Empleado e1 = new Empleado("Juan");
        Proyecto p1 = new Proyecto("Proy 1");
        Proyecto p2 = new Proyecto("Proy 2");
        Proyecto p3 = new Proyecto("Proy 3");

        List<EmpleadoProyecto> rels = new ArrayList<>();
        EmpleadoProyecto e1p1 = new EmpleadoProyecto(e1,p1);
        EmpleadoProyecto e1p2 = new EmpleadoProyecto(e1,p2);
        EmpleadoProyecto e1p3 = new EmpleadoProyecto(e1,p3);
        rels.add(e1p1);
        rels.add(e1p2);
        rels.add(e1p3);

        e1.setProyectos(rels);
        empleadoRepository.save(e1);

        // Se puede borrar el dato directamente tras desvincularlo
        e1p2.getEmp().getProyectos().remove(e1p2);
        e1p2.getProy().getEmpleados().remove(e1p2);
        e1p2.setEmp(null);
        e1p2.setProy(null);
        empleadoProyectoRepository.delete(e1p2);

    }

}
