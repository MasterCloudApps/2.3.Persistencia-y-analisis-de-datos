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

    // Relación
    @OneToMany(mappedBy = "proy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoProyecto> empleados = new ArrayList<>();

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

    public List<EmpleadoProyecto> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoProyecto> empleados) {
        this.empleados = empleados;
    }
}
