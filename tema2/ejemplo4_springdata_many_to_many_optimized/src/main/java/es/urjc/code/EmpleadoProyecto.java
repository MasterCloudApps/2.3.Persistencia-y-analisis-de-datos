package es.urjc.code;

import javax.persistence.*;

@Entity
public class EmpleadoProyecto {

    // La clave primaria está formada por las dos claves ajenas.

    @EmbeddedId
    private EmpleadoProyectoId id;

    @ManyToOne
    @MapsId("empId")
    private Empleado emp;

    @ManyToOne
    @MapsId("proyId")
    private Proyecto proy;

    public EmpleadoProyecto() {}

    public EmpleadoProyecto(Empleado emp, Proyecto proy) {
        this.emp = emp;
        this.proy = proy;
        // Ojo, esta línea crea la clave compuesta:
        this.id = new EmpleadoProyectoId(emp.getId(), proy.getId());
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public Proyecto getProy() {
        return proy;
    }

    public void setProy(Proyecto proy) {
        this.proy = proy;
    }
}
