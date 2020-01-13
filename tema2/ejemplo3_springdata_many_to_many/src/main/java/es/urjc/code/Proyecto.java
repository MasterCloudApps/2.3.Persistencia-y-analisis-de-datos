package es.urjc.code;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author J. M. Colmenar
 */

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String nombreProyecto;

    @ManyToMany(mappedBy = "proyectos")
    private List<Empleado> empleados = new ArrayList<>();


    public Proyecto() { }

    public Proyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
