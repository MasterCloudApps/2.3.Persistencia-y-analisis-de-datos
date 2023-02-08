package es.urjc.code;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmpleadoProyectoId implements Serializable {
    private Long empId;
    private Long proyId;

    public EmpleadoProyectoId() { }

    public EmpleadoProyectoId(Long empId, Long proyId) {
        this.empId = empId;
        this.proyId = proyId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getProyId() {
        return proyId;
    }

    public void setProyId(Long proyId) {
        this.proyId = proyId;
    }
}
