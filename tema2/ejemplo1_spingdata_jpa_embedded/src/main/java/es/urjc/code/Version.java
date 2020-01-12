package es.urjc.code;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Clase con datos sobre la version.
 *
 * @author J. M. Colmenar
 */
@Embeddable
public class Version {

    private String version;
    private Date fecha;

    public Version() {}

    public Version(String version, Date fecha) {
        this.version = version;
        this.fecha = fecha;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Version{" +
                "version='" + version + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
