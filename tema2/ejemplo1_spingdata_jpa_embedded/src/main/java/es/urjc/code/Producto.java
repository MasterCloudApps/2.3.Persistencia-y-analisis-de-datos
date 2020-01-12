package es.urjc.code;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad Producto. Mapeo de objeto incrustado (embedded).
 *
 * @author J. Manuel Colmenar
 */
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Por ejemplo, marca y modelo
    private String datos;

    private Version version;

    public Producto() {
    }

    public Producto(String datos, Version version) {
        this.datos = datos;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", datos='" + datos + '\'' +
                ", version=" + version +
                '}';
    }
}
