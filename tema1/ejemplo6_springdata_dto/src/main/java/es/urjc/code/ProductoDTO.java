package es.urjc.code;

/**
 * DTO como clase para utilizar JPQL
 *
 * @author J. M. Colmenar
 */
public class ProductoDTO {

    private String datos;
    private long numero;

    public ProductoDTO() {
    }

    public ProductoDTO(String datos) {
        this.datos = datos;
    }

    public ProductoDTO(String datos, long numero) {
        this.datos = datos;
        this.numero = numero;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "datos='" + datos + '\'' +
                ", numero=" + numero +
                '}';
    }
}