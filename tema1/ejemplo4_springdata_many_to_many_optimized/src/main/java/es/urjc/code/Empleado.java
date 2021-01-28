package es.urjc.code;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author J. M. Colmenar
 */

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String nombre;

    // Relación
    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpleadoProyecto> proyectos = new ArrayList<>();

    public Empleado() { }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EmpleadoProyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<EmpleadoProyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
